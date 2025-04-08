package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.YundanzhuangtaiEntity;

import com.service.YundanzhuangtaiService;
import com.entity.view.YundanzhuangtaiView;
import com.service.YunshuchengbenService;
import com.entity.YunshuchengbenEntity;
import com.service.YonghuService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 运单状态
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yundanzhuangtai")
public class YundanzhuangtaiController {
    private static final Logger logger = LoggerFactory.getLogger(YundanzhuangtaiController.class);

    @Autowired
    private YundanzhuangtaiService yundanzhuangtaiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private YunshuchengbenService yunshuchengbenService;
    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
            return R.error(511,"权限为空");
        }
        else if("用户".equals(role)){
            if (!params.containsKey("yunshuchengbenName")){
                params.put("yunshuchengbenName","00000000");
            }
        }
        params.put("orderBy","id");
        PageUtils page = yundanzhuangtaiService.queryPage(params);

        //字典表数据转换
        List<YundanzhuangtaiView> list =(List<YundanzhuangtaiView>)page.getList();
        for(YundanzhuangtaiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YundanzhuangtaiEntity yundanzhuangtai = yundanzhuangtaiService.selectById(id);
        if(yundanzhuangtai !=null){
            //entity转view
            YundanzhuangtaiView view = new YundanzhuangtaiView();
            BeanUtils.copyProperties( yundanzhuangtai , view );//把实体数据重构到view中

            //级联表
            YunshuchengbenEntity yunshuchengben = yunshuchengbenService.selectById(yundanzhuangtai.getYunshuchengbenId());
            if(yunshuchengben != null){
                BeanUtils.copyProperties( yunshuchengben , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setYunshuchengbenId(yunshuchengben.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody YundanzhuangtaiEntity yundanzhuangtai, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yundanzhuangtai:{}",this.getClass().getName(),yundanzhuangtai.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
            return R.error(511,"权限为空");
        }
        Wrapper<YundanzhuangtaiEntity> queryWrapper = new EntityWrapper<YundanzhuangtaiEntity>()
            .eq("yunshuchengben_id", yundanzhuangtai.getYunshuchengbenId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YundanzhuangtaiEntity yundanzhuangtaiEntity = yundanzhuangtaiService.selectOne(queryWrapper);
        if(yundanzhuangtaiEntity==null){
            yundanzhuangtai.setCreateTime(new Date());
            yundanzhuangtai.setUpdateTime(new Date());
            yundanzhuangtaiService.insert(yundanzhuangtai);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YundanzhuangtaiEntity yundanzhuangtai, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,yundanzhuangtai:{}",this.getClass().getName(),yundanzhuangtai.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
            return R.error(511,"权限为空");
        }
        //根据字段查询是否有相同数据
        Wrapper<YundanzhuangtaiEntity> queryWrapper = new EntityWrapper<YundanzhuangtaiEntity>()
            .notIn("id",yundanzhuangtai.getId())
            .andNew()
            .eq("yunshuchengben_id", yundanzhuangtai.getYunshuchengbenId())
            .eq("yundanzhuangtai_gongsi", yundanzhuangtai.getYundanzhuangtaiGongsi())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YundanzhuangtaiEntity yundanzhuangtaiEntity = yundanzhuangtaiService.selectOne(queryWrapper);
        yundanzhuangtai.setUpdateTime(new Date());
        if(yundanzhuangtaiEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      yundanzhuangtai.set
            //  }
            yundanzhuangtaiService.updateById(yundanzhuangtai);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        yundanzhuangtaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }



    /**
    * 前端列表
    */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
            return R.error(511,"权限为空");
        }
        else if("用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = yundanzhuangtaiService.queryPage(params);

        //字典表数据转换
        List<YundanzhuangtaiView> list =(List<YundanzhuangtaiView>)page.getList();
        for(YundanzhuangtaiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YundanzhuangtaiEntity yundanzhuangtai = yundanzhuangtaiService.selectById(id);
            if(yundanzhuangtai !=null){
                //entity转view
                YundanzhuangtaiView view = new YundanzhuangtaiView();
                BeanUtils.copyProperties( yundanzhuangtai , view );//把实体数据重构到view中

                //级联表
                    YunshuchengbenEntity yunshuchengben = yunshuchengbenService.selectById(yundanzhuangtai.getYunshuchengbenId());
                if(yunshuchengben != null){
                    BeanUtils.copyProperties( yunshuchengben , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYunshuchengbenId(yunshuchengben.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody YundanzhuangtaiEntity yundanzhuangtai, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,yundanzhuangtai:{}",this.getClass().getName(),yundanzhuangtai.toString());
        Wrapper<YundanzhuangtaiEntity> queryWrapper = new EntityWrapper<YundanzhuangtaiEntity>()
            .eq("yunshuchengben_id", yundanzhuangtai.getYunshuchengbenId())
            .eq("yundanzhuangtai_gongsi", yundanzhuangtai.getYundanzhuangtaiGongsi())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YundanzhuangtaiEntity yundanzhuangtaiEntity = yundanzhuangtaiService.selectOne(queryWrapper);
        if(yundanzhuangtaiEntity==null){
            yundanzhuangtai.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      yundanzhuangtai.set
        //  }
        yundanzhuangtaiService.insert(yundanzhuangtai);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }





}

