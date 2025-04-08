package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YundanzhuangtaiEntity;
import java.util.Map;

/**
 * 运单状态 服务类
 */
public interface YundanzhuangtaiService extends IService<YundanzhuangtaiEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}