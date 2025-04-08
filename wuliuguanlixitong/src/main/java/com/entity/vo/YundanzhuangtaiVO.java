package com.entity.vo;

import com.entity.YundanzhuangtaiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 运单状态
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yundanzhuangtai")
public class YundanzhuangtaiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "update_time")
    private Date updateTime;


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

}
