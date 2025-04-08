package com.entity.model;

import com.entity.YundanzhuangtaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 运单状态
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YundanzhuangtaiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 承运单号
     */
    private Integer yunshuchengbenId;


    /**
     * 目前状态
     */
    private String yundanzhuangtaiGongsi;


    /**
     * 更新时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date updateTime;


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
    public Integer getYunshuchengbenId() {
        return yunshuchengbenId;
    }


    /**
	 * 设置：承运单号
	 */
    public void setYunshuchengbenId(Integer yunshuchengbenId) {
        this.yunshuchengbenId = yunshuchengbenId;
    }
    /**
	 * 获取：目前状态
	 */
    public String getYundanzhuangtaiGongsi() {
        return yundanzhuangtaiGongsi;
    }


    /**
	 * 设置：目前状态
	 */
    public void setYundanzhuangtaiGongsi(String yundanzhuangtaiGongsi) {
        this.yundanzhuangtaiGongsi = yundanzhuangtaiGongsi;
    }
    /**
	 * 获取：更新时间
	 */
    public Date getUpdateTime() {
        return updateTime;
    }


    /**
	 * 设置：更新时间
	 */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
