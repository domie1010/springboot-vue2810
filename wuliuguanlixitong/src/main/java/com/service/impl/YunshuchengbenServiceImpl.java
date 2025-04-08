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

import com.dao.YunshuchengbenDao;
import com.entity.YunshuchengbenEntity;
import com.service.YunshuchengbenService;
import com.entity.view.YunshuchengbenView;

/**
 * 运输成本 服务实现类
 */
@Service("yunshuchengbenService")
@Transactional
public class YunshuchengbenServiceImpl extends ServiceImpl<YunshuchengbenDao, YunshuchengbenEntity> implements YunshuchengbenService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<YunshuchengbenView> page =new Query<YunshuchengbenView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
