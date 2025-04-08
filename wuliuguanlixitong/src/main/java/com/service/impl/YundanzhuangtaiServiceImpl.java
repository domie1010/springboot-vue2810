package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.dao.YundanzhuangtaiDao;
import com.entity.YundanzhuangtaiEntity;
import com.service.YundanzhuangtaiService;
import com.entity.view.YundanzhuangtaiView;

/**
 * 运单状态 服务实现类
 */
@Service("yundanzhuangtaiService")
@Transactional
public class YundanzhuangtaiServiceImpl extends ServiceImpl<YundanzhuangtaiDao, YundanzhuangtaiEntity> implements YundanzhuangtaiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<YundanzhuangtaiView> page =new Query<YundanzhuangtaiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
