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

import com.entity.YunshuchengbenEntity;

import com.service.YunshuchengbenService;
import com.entity.view.YunshuchengbenView;
import com.service.YonghuService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 运输成本
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yunshuchengben")
public class YunshuchengbenController {
    private static final Logger logger = LoggerFactory.getLogger(YunshuchengbenController.class);

    @Autowired
    private YunshuchengbenService yunshuchengbenService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
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
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        params.put("orderBy","id");
        PageUtils page = yunshuchengbenService.queryPage(params);

        //字典表数据转换
        List<YunshuchengbenView> list =(List<YunshuchengbenView>)page.getList();
        for(YunshuchengbenView c:list){
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
        YunshuchengbenEntity yunshuchengben = yunshuchengbenService.selectById(id);
        if(yunshuchengben !=null){
            //entity转view
            YunshuchengbenView view = new YunshuchengbenView();
            BeanUtils.copyProperties( yunshuchengben , view );//把实体数据重构到view中

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
    public R save(@RequestBody YunshuchengbenEntity yunshuchengben, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yunshuchengben:{}",this.getClass().getName(),yunshuchengben.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
            return R.error(511,"权限为空");
        }
        Wrapper<YunshuchengbenEntity> queryWrapper = new EntityWrapper<YunshuchengbenEntity>()
            .eq("yunshuchengben_name", yunshuchengben.getYunshuchengbenName())
            .eq("xinghao_types", yunshuchengben.getXinghaoTypes())
            .eq("yunshuchengben_gongsi", yunshuchengben.getYunshuchengbenGongsi())
            .eq("yunshuchengben_phone", yunshuchengben.getYunshuchengbenPhone())
            .eq("yunshuchengben_dizhi", yunshuchengben.getYunshuchengbenDizhi())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YunshuchengbenEntity yunshuchengbenEntity = yunshuchengbenService.selectOne(queryWrapper);
        if(yunshuchengbenEntity==null){
            yunshuchengben.setCreateTime(new Date());
            yunshuchengbenService.insert(yunshuchengben);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YunshuchengbenEntity yunshuchengben, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,yunshuchengben:{}",this.getClass().getName(),yunshuchengben.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
            return R.error(511,"权限为空");
        }
        //根据字段查询是否有相同数据
        Wrapper<YunshuchengbenEntity> queryWrapper = new EntityWrapper<YunshuchengbenEntity>()
            .notIn("id",yunshuchengben.getId())
            .andNew()
            .eq("yunshuchengben_name", yunshuchengben.getYunshuchengbenName())
            .eq("xinghao_types", yunshuchengben.getXinghaoTypes())
            .eq("yunshuchengben_gongsi", yunshuchengben.getYunshuchengbenGongsi())
            .eq("yunshuchengben_phone", yunshuchengben.getYunshuchengbenPhone())
            .eq("yunshuchengben_dizhi", yunshuchengben.getYunshuchengbenDizhi())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YunshuchengbenEntity yunshuchengbenEntity = yunshuchengbenService.selectOne(queryWrapper);
        if(yunshuchengbenEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      yunshuchengben.set
            //  }
            yunshuchengbenService.updateById(yunshuchengben);//根据id更新
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
        yunshuchengbenService.deleteBatchIds(Arrays.asList(ids));
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
        PageUtils page = yunshuchengbenService.queryPage(params);

        //字典表数据转换
        List<YunshuchengbenView> list =(List<YunshuchengbenView>)page.getList();
        for(YunshuchengbenView c:list){
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
        YunshuchengbenEntity yunshuchengben = yunshuchengbenService.selectById(id);
            if(yunshuchengben !=null){
                //entity转view
                YunshuchengbenView view = new YunshuchengbenView();
                BeanUtils.copyProperties( yunshuchengben , view );//把实体数据重构到view中

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
    public R add(@RequestBody YunshuchengbenEntity yunshuchengben, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,yunshuchengben:{}",this.getClass().getName(),yunshuchengben.toString());
        Wrapper<YunshuchengbenEntity> queryWrapper = new EntityWrapper<YunshuchengbenEntity>()
            .eq("yunshuchengben_name", yunshuchengben.getYunshuchengbenName())
            .eq("xinghao_types", yunshuchengben.getXinghaoTypes())
            .eq("yunshuchengben_gongsi", yunshuchengben.getYunshuchengbenGongsi())
            .eq("yunshuchengben_phone", yunshuchengben.getYunshuchengbenPhone())
            .eq("yunshuchengben_dizhi", yunshuchengben.getYunshuchengbenDizhi())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YunshuchengbenEntity yunshuchengbenEntity = yunshuchengbenService.selectOne(queryWrapper);
        if(yunshuchengbenEntity==null){
            yunshuchengben.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      yunshuchengben.set
        //  }
        yunshuchengbenService.insert(yunshuchengben);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }





}

