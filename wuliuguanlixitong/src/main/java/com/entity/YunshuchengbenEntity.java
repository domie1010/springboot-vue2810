package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 运输成本
 *
 * @author 
 * @email
 */
@TableName("yunshuchengben")
public class YunshuchengbenEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YunshuchengbenEntity() {

	}

	public YunshuchengbenEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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
    @TableField(value = "ruzhi_time",fill = FieldFill.UPDATE)

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
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "Yunshuchengben{" +
            "id=" + id +
            ", yunshuchengbenName=" + yunshuchengbenName +
            ", xinghaoTypes=" + xinghaoTypes +
            ", ruzhiTime=" + ruzhiTime +
            ", yunshuchengbenMoney=" + yunshuchengbenMoney +
            ", yunshuchengbenGongsi=" + yunshuchengbenGongsi +
            ", yunshuchengbenPhone=" + yunshuchengbenPhone +
            ", yunshuchengbenDizhi=" + yunshuchengbenDizhi +
            ", createTime=" + createTime +
        "}";
    }
}
