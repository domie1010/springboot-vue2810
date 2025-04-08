package com.entity.model;

import com.entity.CheliangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 车辆信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class CheliangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 车牌
     */
    private String cheliangName;


    /**
     * 车辆型号
     */
    private Integer xinghaoTypes;


    /**
     * 购买时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：车牌
	 */
    public String getCheliangName() {
        return cheliangName;
    }


    /**
	 * 设置：车牌
	 */
    public void setCheliangName(String cheliangName) {
        this.cheliangName = cheliangName;
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
	 * 获取：购买时间
	 */
    public Date getGoumaiTime() {
        return goumaiTime;
    }


    /**
	 * 设置：购买时间
	 */
    public void setGoumaiTime(Date goumaiTime) {
        this.goumaiTime = goumaiTime;
    }
    /**
	 * 获取：车辆价格
	 */
    public Double getCheliangMoney() {
        return cheliangMoney;
    }


    /**
	 * 设置：车辆价格
	 */
    public void setCheliangMoney(Double cheliangMoney) {
        this.cheliangMoney = cheliangMoney;
    }
    /**
	 * 获取：生产厂家
	 */
    public String getCheliangChangjia() {
        return cheliangChangjia;
    }


    /**
	 * 设置：生产厂家
	 */
    public void setCheliangChangjia(String cheliangChangjia) {
        this.cheliangChangjia = cheliangChangjia;
    }
    /**
	 * 获取：联系电话
	 */
    public String getCheliangPhone() {
        return cheliangPhone;
    }


    /**
	 * 设置：联系电话
	 */
    public void setCheliangPhone(String cheliangPhone) {
        this.cheliangPhone = cheliangPhone;
    }
    /**
	 * 获取：联系地址
	 */
    public String getCheliangDizhi() {
        return cheliangDizhi;
    }


    /**
	 * 设置：联系地址
	 */
    public void setCheliangDizhi(String cheliangDizhi) {
        this.cheliangDizhi = cheliangDizhi;
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
