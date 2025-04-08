package com.entity.vo;

import com.entity.CheliangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 车辆信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("cheliang")
public class CheliangVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 车牌
     */

    @TableField(value = "cheliang_name")
    private String cheliangName;


    /**
     * 车辆型号
     */

    @TableField(value = "xinghao_types")
    private Integer xinghaoTypes;


    /**
     * 购买时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "goumai_time")
    private Date goumaiTime;


    /**
     * 车辆价格
     */

    @TableField(value = "cheliang_money")
    private Double cheliangMoney;


    /**
     * 生产厂家
     */

    @TableField(value = "cheliang_changjia")
    private String cheliangChangjia;


    /**
     * 联系电话
     */

    @TableField(value = "cheliang_phone")
    private String cheliangPhone;


    /**
     * 联系地址
     */

    @TableField(value = "cheliang_dizhi")
    private String cheliangDizhi;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：车牌
	 */
    public String getCheliangName() {
        return cheliangName;
    }


    /**
	 * 获取：车牌
	 */

    public void setCheliangName(String cheliangName) {
        this.cheliangName = cheliangName;
    }
    /**
	 * 设置：车辆型号
	 */
    public Integer getXinghaoTypes() {
        return xinghaoTypes;
    }


    /**
	 * 获取：车辆型号
	 */

    public void setXinghaoTypes(Integer xinghaoTypes) {
        this.xinghaoTypes = xinghaoTypes;
    }
    /**
	 * 设置：购买时间
	 */
    public Date getGoumaiTime() {
        return goumaiTime;
    }


    /**
	 * 获取：购买时间
	 */

    public void setGoumaiTime(Date goumaiTime) {
        this.goumaiTime = goumaiTime;
    }
    /**
	 * 设置：车辆价格
	 */
    public Double getCheliangMoney() {
        return cheliangMoney;
    }


    /**
	 * 获取：车辆价格
	 */

    public void setCheliangMoney(Double cheliangMoney) {
        this.cheliangMoney = cheliangMoney;
    }
    /**
	 * 设置：生产厂家
	 */
    public String getCheliangChangjia() {
        return cheliangChangjia;
    }


    /**
	 * 获取：生产厂家
	 */

    public void setCheliangChangjia(String cheliangChangjia) {
        this.cheliangChangjia = cheliangChangjia;
    }
    /**
	 * 设置：联系电话
	 */
    public String getCheliangPhone() {
        return cheliangPhone;
    }


    /**
	 * 获取：联系电话
	 */

    public void setCheliangPhone(String cheliangPhone) {
        this.cheliangPhone = cheliangPhone;
    }
    /**
	 * 设置：联系地址
	 */
    public String getCheliangDizhi() {
        return cheliangDizhi;
    }


    /**
	 * 获取：联系地址
	 */

    public void setCheliangDizhi(String cheliangDizhi) {
        this.cheliangDizhi = cheliangDizhi;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
