package com.entity.view;

import com.entity.ShijiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 司机信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("shiji")
public class ShijiView extends ShijiEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 驾照类型的值
		*/
		private String jiazhaoValue;



	public ShijiView() {

	}

	public ShijiView(ShijiEntity shijiEntity) {
		try {
			BeanUtils.copyProperties(this, shijiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 驾照类型的值
			*/
			public String getJiazhaoValue() {
				return jiazhaoValue;
			}
			/**
			* 设置： 驾照类型的值
			*/
			public void setJiazhaoValue(String jiazhaoValue) {
				this.jiazhaoValue = jiazhaoValue;
			}











}
