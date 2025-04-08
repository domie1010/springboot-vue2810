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
 * 司机信息
 *
 * @author 
 * @email
 */
@TableName("shiji")
public class ShijiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShijiEntity() {

	}

	public ShijiEntity(T t) {
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
     * 司机名称
     */
    @TableField(value = "shiji_name")

    private String shijiName;


    /**
     * 驾照类型
     */
    @TableField(value = "jiazhao_types")

    private Integer jiazhaoTypes;


    /**
     * 入职时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "ruzhi_time",fill = FieldFill.UPDATE)

    private Date ruzhiTime;


    /**
     * 联系方式
     */
    @TableField(value = "shiji_phone")

    private String shijiPhone;


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
	 * 设置：司机名称
	 */
    public String getShijiName() {
        return shijiName;
    }


    /**
	 * 获取：司机名称
	 */

    public void setShijiName(String shijiName) {
        this.shijiName = shijiName;
    }
    /**
	 * 设置：驾照类型
	 */
    public Integer getJiazhaoTypes() {
        return jiazhaoTypes;
    }


    /**
	 * 获取：驾照类型
	 */

    public void setJiazhaoTypes(Integer jiazhaoTypes) {
        this.jiazhaoTypes = jiazhaoTypes;
    }
    /**
	 * 设置：入职时间
	 */
    public Date getRuzhiTime() {
        return ruzhiTime;
    }


    /**
	 * 获取：入职时间
	 */

    public void setRuzhiTime(Date ruzhiTime) {
        this.ruzhiTime = ruzhiTime;
    }
    /**
	 * 设置：联系方式
	 */
    public String getShijiPhone() {
        return shijiPhone;
    }


    /**
	 * 获取：联系方式
	 */

    public void setShijiPhone(String shijiPhone) {
        this.shijiPhone = shijiPhone;
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
        return "Shiji{" +
            "id=" + id +
            ", shijiName=" + shijiName +
            ", jiazhaoTypes=" + jiazhaoTypes +
            ", ruzhiTime=" + ruzhiTime +
            ", shijiPhone=" + shijiPhone +
            ", createTime=" + createTime +
        "}";
    }
}
