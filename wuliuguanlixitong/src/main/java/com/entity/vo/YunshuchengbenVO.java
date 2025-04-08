package com.entity.vo;

import com.entity.YunshuchengbenEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 运输成本
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yunshuchengben")
public class YunshuchengbenVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 承运单号
     */

    @TableField(value = "yunshuchengben_name")
    private String yunshuchengbenName;


    /**
     * 车辆型号
     */

    @TableField(value = "xinghao_types")
    private Integer xinghaoTypes;


    /**
     * 承运时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "ruzhi_time")
    private Date ruzhiTime;


    /**
     * 承运价格
     */

    @TableField(value = "yunshuchengben_money")
    private Double yunshuchengbenMoney;


    /**
     * 承运公司
     */

    @TableField(value = "yunshuchengben_gongsi")
    private String yunshuchengbenGongsi;


    /**
     * 联系方式
     */

    @TableField(value = "yunshuchengben_phone")
    private String yunshuchengbenPhone;


    /**
     * 联系地址
     */

    @TableField(value = "yunshuchengben_dizhi")
    private String yunshuchengbenDizhi;


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
	 * 设置：承运单号
	 */
    public String getYunshuchengbenName() {
        return yunshuchengbenName;
    }


    /**
	 * 获取：承运单号
	 */

    public void setYunshuchengbenName(String yunshuchengbenName) {
        this.yunshuchengbenName = yunshuchengbenName;
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
	 * 设置：承运时间
	 */
    public Date getRuzhiTime() {
        return ruzhiTime;
    }


    /**
	 * 获取：承运时间
	 */

    public void setRuzhiTime(Date ruzhiTime) {
        this.ruzhiTime = ruzhiTime;
    }
    /**
	 * 设置：承运价格
	 */
    public Double getYunshuchengbenMoney() {
        return yunshuchengbenMoney;
    }


    /**
	 * 获取：承运价格
	 */

    public void setYunshuchengbenMoney(Double yunshuchengbenMoney) {
        this.yunshuchengbenMoney = yunshuchengbenMoney;
    }
    /**
	 * 设置：承运公司
	 */
    public String getYunshuchengbenGongsi() {
        return yunshuchengbenGongsi;
    }


    /**
	 * 获取：承运公司
	 */

    public void setYunshuchengbenGongsi(String yunshuchengbenGongsi) {
        this.yunshuchengbenGongsi = yunshuchengbenGongsi;
    }
    /**
	 * 设置：联系方式
	 */
    public String getYunshuchengbenPhone() {
        return yunshuchengbenPhone;
    }


    /**
	 * 获取：联系方式
	 */

    public void setYunshuchengbenPhone(String yunshuchengbenPhone) {
        this.yunshuchengbenPhone = yunshuchengbenPhone;
    }
    /**
	 * 设置：联系地址
	 */
    public String getYunshuchengbenDizhi() {
        return yunshuchengbenDizhi;
    }


    /**
	 * 获取：联系地址
	 */

    public void setYunshuchengbenDizhi(String yunshuchengbenDizhi) {
        this.yunshuchengbenDizhi = yunshuchengbenDizhi;
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
