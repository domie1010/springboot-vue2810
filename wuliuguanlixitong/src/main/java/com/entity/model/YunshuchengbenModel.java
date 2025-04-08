package com.entity.model;

import com.entity.YunshuchengbenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 运输成本
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YunshuchengbenModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 承运单号
     */
    private String yunshuchengbenName;


    /**
     * 车辆型号
     */
    private Integer xinghaoTypes;


    /**
     * 承运时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：承运单号
	 */
    public String getYunshuchengbenName() {
        return yunshuchengbenName;
    }


    /**
	 * 设置：承运单号
	 */
    public void setYunshuchengbenName(String yunshuchengbenName) {
        this.yunshuchengbenName = yunshuchengbenName;
    }
    /**
	 * 获取：车辆型号
	 */
    public Integer getXinghaoTypes() {
        return xinghaoTypes;
    }


    /**
	 * 设置：车辆型号
	 */
    public void setXinghaoTypes(Integer xinghaoTypes) {
        this.xinghaoTypes = xinghaoTypes;
    }
    /**
	 * 获取：承运时间
	 */
    public Date getRuzhiTime() {
        return ruzhiTime;
    }


    /**
	 * 设置：承运时间
	 */
    public void setRuzhiTime(Date ruzhiTime) {
        this.ruzhiTime = ruzhiTime;
    }
    /**
	 * 获取：承运价格
	 */
    public Double getYunshuchengbenMoney() {
        return yunshuchengbenMoney;
    }


    /**
	 * 设置：承运价格
	 */
    public void setYunshuchengbenMoney(Double yunshuchengbenMoney) {
        this.yunshuchengbenMoney = yunshuchengbenMoney;
    }
    /**
	 * 获取：承运公司
	 */
    public String getYunshuchengbenGongsi() {
        return yunshuchengbenGongsi;
    }


    /**
	 * 设置：承运公司
	 */
    public void setYunshuchengbenGongsi(String yunshuchengbenGongsi) {
        this.yunshuchengbenGongsi = yunshuchengbenGongsi;
    }
    /**
	 * 获取：联系方式
	 */
    public String getYunshuchengbenPhone() {
        return yunshuchengbenPhone;
    }


    /**
	 * 设置：联系方式
	 */
    public void setYunshuchengbenPhone(String yunshuchengbenPhone) {
        this.yunshuchengbenPhone = yunshuchengbenPhone;
    }
    /**
	 * 获取：联系地址
	 */
    public String getYunshuchengbenDizhi() {
        return yunshuchengbenDizhi;
    }


    /**
	 * 设置：联系地址
	 */
    public void setYunshuchengbenDizhi(String yunshuchengbenDizhi) {
        this.yunshuchengbenDizhi = yunshuchengbenDizhi;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
