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
 * 运单状态
 *
 * @author 
 * @email
 */
@TableName("yundanzhuangtai")
public class YundanzhuangtaiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YundanzhuangtaiEntity() {

	}

	public YundanzhuangtaiEntity(T t) {
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
    @TableField(value = "yunshuchengben_id")

    private Integer yunshuchengbenId;


    /**
     * 目前状态
     */
    @TableField(value = "yundanzhuangtai_gongsi")

    private String yundanzhuangtaiGongsi;


    /**
     * 更新时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "update_time",fill = FieldFill.UPDATE)

    private Date updateTime;


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
    public Integer getYunshuchengbenId() {
        return yunshuchengbenId;
    }


    /**
	 * 获取：承运单号
	 */

    public void setYunshuchengbenId(Integer yunshuchengbenId) {
        this.yunshuchengbenId = yunshuchengbenId;
    }
    /**
	 * 设置：目前状态
	 */
    public String getYundanzhuangtaiGongsi() {
        return yundanzhuangtaiGongsi;
    }


    /**
	 * 获取：目前状态
	 */

    public void setYundanzhuangtaiGongsi(String yundanzhuangtaiGongsi) {
        this.yundanzhuangtaiGongsi = yundanzhuangtaiGongsi;
    }
    /**
	 * 设置：更新时间
	 */
    public Date getUpdateTime() {
        return updateTime;
    }


    /**
	 * 获取：更新时间
	 */

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
        return "Yundanzhuangtai{" +
            "id=" + id +
            ", yunshuchengbenId=" + yunshuchengbenId +
            ", yundanzhuangtaiGongsi=" + yundanzhuangtaiGongsi +
            ", updateTime=" + updateTime +
            ", createTime=" + createTime +
        "}";
    }
}
