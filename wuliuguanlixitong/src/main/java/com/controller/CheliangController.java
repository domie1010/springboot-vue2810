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

import com.entity.CheliangEntity;

import com.service.CheliangService;
import com.entity.view.CheliangView;
import com.service.YonghuService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 车辆信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/cheliang")
public class CheliangController {
    private static final Logger logger = LoggerFactory.getLogger(CheliangController.class);

    @Autowired
    private CheliangService cheliangService;


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
        PageUtils page = cheliangService.queryPage(params);

        //字典表数据转换
        List<CheliangView> list =(List<CheliangView>)page.getList();
        for(CheliangView c:list){
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
        CheliangEntity cheliang = cheliangService.selectById(id);
        if(cheliang !=null){
            //entity转view
            CheliangView view = new CheliangView();
            BeanUtils.copyProperties( cheliang , view );//把实体数据重构到view中

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
    public R save(@RequestBody CheliangEntity cheliang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,cheliang:{}",this.getClass().getName(),cheliang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
            return R.error(511,"权限为空");
        }
        Wrapper<CheliangEntity> queryWrapper = new EntityWrapper<CheliangEntity>()
            .eq("cheliang_name", cheliang.getCheliangName())
            .eq("xinghao_types", cheliang.getXinghaoTypes())
            .eq("cheliang_changjia", cheliang.getCheliangChangjia())
            .eq("cheliang_phone", cheliang.getCheliangPhone())
            .eq("cheliang_dizhi", cheliang.getCheliangDizhi())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CheliangEntity cheliangEntity = cheliangService.selectOne(queryWrapper);
        if(cheliangEntity==null){
            cheliang.setCreateTime(new Date());
            cheliangService.insert(cheliang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody CheliangEntity cheliang, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,cheliang:{}",this.getClass().getName(),cheliang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
            return R.error(511,"权限为空");
        }
        //根据字段查询是否有相同数据
        Wrapper<CheliangEntity> queryWrapper = new EntityWrapper<CheliangEntity>()
            .notIn("id",cheliang.getId())
            .andNew()
            .eq("cheliang_name", cheliang.getCheliangName())
            .eq("xinghao_types", cheliang.getXinghaoTypes())
            .eq("cheliang_changjia", cheliang.getCheliangChangjia())
            .eq("cheliang_phone", cheliang.getCheliangPhone())
            .eq("cheliang_dizhi", cheliang.getCheliangDizhi())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CheliangEntity cheliangEntity = cheliangService.selectOne(queryWrapper);
        if(cheliangEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      cheliang.set
            //  }
            cheliangService.updateById(cheliang);//根据id更新
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
        cheliangService.deleteBatchIds(Arrays.asList(ids));
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
        PageUtils page = cheliangService.queryPage(params);

        //字典表数据转换
        List<CheliangView> list =(List<CheliangView>)page.getList();
        for(CheliangView c:list){
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
        CheliangEntity cheliang = cheliangService.selectById(id);
            if(cheliang !=null){
                //entity转view
                CheliangView view = new CheliangView();
                BeanUtils.copyProperties( cheliang , view );//把实体数据重构到view中

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
    public R add(@RequestBody CheliangEntity cheliang, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,cheliang:{}",this.getClass().getName(),cheliang.toString());
        Wrapper<CheliangEntity> queryWrapper = new EntityWrapper<CheliangEntity>()
            .eq("cheliang_name", cheliang.getCheliangName())
            .eq("xinghao_types", cheliang.getXinghaoTypes())
            .eq("cheliang_changjia", cheliang.getCheliangChangjia())
            .eq("cheliang_phone", cheliang.getCheliangPhone())
            .eq("cheliang_dizhi", cheliang.getCheliangDizhi())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CheliangEntity cheliangEntity = cheliangService.selectOne(queryWrapper);
        if(cheliangEntity==null){
            cheliang.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      cheliang.set
        //  }
        cheliangService.insert(cheliang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }





}

