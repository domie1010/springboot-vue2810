package com.entity.view;

import com.entity.RenwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 承运任务
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("renwu")
public class RenwuView extends RenwuEntity implements Serializable {
    private static final long serialVersionUID = 1L;



		//级联表 cheliang
			/**
			* 车牌
			*/
			private String cheliangName;
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
			* 购买时间
			*/
			private Date goumaiTime;
			/**
			* 车辆价格
			*/
			private Double cheliangMoney;
			/**
			* 生产厂家
			*/
			private String cheliangChangjia;
			/**
			* 联系电话
			*/
			private String cheliangPhone;
			/**
			* 联系地址
			*/
			private String cheliangDizhi;

		//级联表 yunshuchengben
			/**
			* 承运单号
			*/
			private String yunshuchengbenName;
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

	public RenwuView() {

	}

	public RenwuView(RenwuEntity renwuEntity) {
		try {
			BeanUtils.copyProperties(this, renwuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



				//级联表的get和set cheliang
					/**
					* 获取： 车牌
					*/
					public String getCheliangName() {
						return cheliangName;
					}
					/**
					* 设置： 车牌
					*/
					public void setCheliangName(String cheliangName) {
						this.cheliangName = cheliangName;
					}
					/**
					* 获取： 购买时间
					*/
					public Date getGoumaiTime() {
						return goumaiTime;
					}
					/**
					* 设置： 购买时间
					*/
					public void setGoumaiTime(Date goumaiTime) {
						this.goumaiTime = goumaiTime;
					}
					/**
					* 获取： 车辆价格
					*/
					public Double getCheliangMoney() {
						return cheliangMoney;
					}
					/**
					* 设置： 车辆价格
					*/
					public void setCheliangMoney(Double cheliangMoney) {
						this.cheliangMoney = cheliangMoney;
					}
					/**
					* 获取： 生产厂家
					*/
					public String getCheliangChangjia() {
						return cheliangChangjia;
					}
					/**
					* 设置： 生产厂家
					*/
					public void setCheliangChangjia(String cheliangChangjia) {
						this.cheliangChangjia = cheliangChangjia;
					}
					/**
					* 获取： 联系电话
					*/
					public String getCheliangPhone() {
						return cheliangPhone;
					}
					/**
					* 设置： 联系电话
					*/
					public void setCheliangPhone(String cheliangPhone) {
						this.cheliangPhone = cheliangPhone;
					}
					/**
					* 获取： 联系地址
					*/
					public String getCheliangDizhi() {
						return cheliangDizhi;
					}
					/**
					* 设置： 联系地址
					*/
					public void setCheliangDizhi(String cheliangDizhi) {
						this.cheliangDizhi = cheliangDizhi;
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
