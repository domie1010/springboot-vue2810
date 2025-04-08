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
 * 承运任务
 *
 * @author 
 * @email
 */
@TableName("renwu")
public class RenwuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public RenwuEntity() {

	}

	public RenwuEntity(T t) {
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
     * 运输车辆
     */
    @TableField(value = "cheliang_id")

    private Integer cheliangId;


    /**
     * 承运单号
     */
    @TableField(value = "yunshuchengben_id")

    private Integer yunshuchengbenId;


    /**
     * 承运时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "chengyun_time",fill = FieldFill.UPDATE)

    private Date chengyunTime;


    /**
     * 接收时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "jieshou_time",fill = FieldFill.UPDATE)

    private Date jieshouTime;


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
	 * 设置：运输车辆
	 */
    public Integer getCheliangId() {
        return cheliangId;
    }


    /**
	 * 获取：运输车辆
	 */

    public void setCheliangId(Integer cheliangId) {
        this.cheliangId = cheliangId;
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
	 * 设置：承运时间
	 */
    public Date getChengyunTime() {
        return chengyunTime;
    }


    /**
	 * 获取：承运时间
	 */

    public void setChengyunTime(Date chengyunTime) {
        this.chengyunTime = chengyunTime;
    }
    /**
	 * 设置：接收时间
	 */
    public Date getJieshouTime() {
        return jieshouTime;
    }


    /**
	 * 获取：接收时间
	 */

    public void setJieshouTime(Date jieshouTime) {
        this.jieshouTime = jieshouTime;
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
        return "Renwu{" +
            "id=" + id +
            ", cheliangId=" + cheliangId +
            ", yunshuchengbenId=" + yunshuchengbenId +
            ", chengyunTime=" + chengyunTime +
            ", jieshouTime=" + jieshouTime +
            ", createTime=" + createTime +
        "}";
    }
}
