package com.entity.view;

import com.entity.YunshuchengbenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 运输成本
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("yunshuchengben")
public class YunshuchengbenView extends YunshuchengbenEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 车辆型号的值
		*/
		private String xinghaoValue;



	public YunshuchengbenView() {

	}

	public YunshuchengbenView(YunshuchengbenEntity yunshuchengbenEntity) {
		try {
			BeanUtils.copyProperties(this, yunshuchengbenEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 车辆型号的值
			*/
			public String getXinghaoValue() {
				return xinghaoValue;
			}
			/**
			* 设置： 车辆型号的值
			*/
			public void setXinghaoValue(String xinghaoValue) {
				this.xinghaoValue = xinghaoValue;
			}











}
