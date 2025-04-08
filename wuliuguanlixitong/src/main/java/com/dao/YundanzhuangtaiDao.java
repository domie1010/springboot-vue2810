package com.dao;

import com.entity.YundanzhuangtaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YundanzhuangtaiView;

/**
 * 运单状态 Dao 接口
 *
 * @author 
 */
public interface YundanzhuangtaiDao extends BaseMapper<YundanzhuangtaiEntity> {

   List<YundanzhuangtaiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
