package com.entity.view;

import com.entity.YundanzhuangtaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 运单状态
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("yundanzhuangtai")
public class YundanzhuangtaiView extends YundanzhuangtaiEntity implements Serializable {
    private static final long serialVersionUID = 1L;



		//级联表 yunshuchengben
			/**
			* 承运单号
			*/
			private String yunshuchengbenName;
			/**
			* 车辆型号
			*/
			private Integer xinghaoTypes;
				/**
				* 车辆型号的值
				*/
				private String xinghaoValue;
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			/**
			* 承运时间
			*/
			private Date ruzhiTime;
			/**
			* 承运价格
			*/
			private Double yunshuchengbenMoney;
			/**
			* 承运公司
			*/
			private String yunshuchengbenGongsi;
			/**
			* 联系方式
			*/
			private String yunshuchengbenPhone;
			/**
			* 联系地址
			*/
			private String yunshuchengbenDizhi;

	public YundanzhuangtaiView() {

	}

	public YundanzhuangtaiView(YundanzhuangtaiEntity yundanzhuangtaiEntity) {
		try {
			BeanUtils.copyProperties(this, yundanzhuangtaiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





















				//级联表的get和set yunshuchengben
					/**
					* 获取： 承运单号
					*/
					public String getYunshuchengbenName() {
						return yunshuchengbenName;
					}
					/**
					* 设置： 承运单号
					*/
					public void setYunshuchengbenName(String yunshuchengbenName) {
						this.yunshuchengbenName = yunshuchengbenName;
					}
					/**
					* 获取： 车辆型号
					*/
					public Integer getXinghaoTypes() {
						return xinghaoTypes;
					}
					/**
					* 设置： 车辆型号
					*/
					public void setXinghaoTypes(Integer xinghaoTypes) {
						this.xinghaoTypes = xinghaoTypes;
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
					/**
					* 获取： 承运时间
					*/
					public Date getRuzhiTime() {
						return ruzhiTime;
					}
					/**
					* 设置： 承运时间
					*/
					public void setRuzhiTime(Date ruzhiTime) {
						this.ruzhiTime = ruzhiTime;
					}
					/**
					* 获取： 承运价格
					*/
					public Double getYunshuchengbenMoney() {
						return yunshuchengbenMoney;
					}
					/**
					* 设置： 承运价格
					*/
					public void setYunshuchengbenMoney(Double yunshuchengbenMoney) {
						this.yunshuchengbenMoney = yunshuchengbenMoney;
					}
					/**
					* 获取： 承运公司
					*/
					public String getYunshuchengbenGongsi() {
						return yunshuchengbenGongsi;
					}
					/**
					* 设置： 承运公司
					*/
					public void setYunshuchengbenGongsi(String yunshuchengbenGongsi) {
						this.yunshuchengbenGongsi = yunshuchengbenGongsi;
					}
					/**
					* 获取： 联系方式
					*/
					public String getYunshuchengbenPhone() {
						return yunshuchengbenPhone;
					}
					/**
					* 设置： 联系方式
					*/
					public void setYunshuchengbenPhone(String yunshuchengbenPhone) {
						this.yunshuchengbenPhone = yunshuchengbenPhone;
					}
					/**
					* 获取： 联系地址
					*/
					public String getYunshuchengbenDizhi() {
						return yunshuchengbenDizhi;
					}
					/**
					* 设置： 联系地址
					*/
					public void setYunshuchengbenDizhi(String yunshuchengbenDizhi) {
						this.yunshuchengbenDizhi = yunshuchengbenDizhi;
					}


}
