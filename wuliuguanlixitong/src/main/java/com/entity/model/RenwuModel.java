package com.entity.model;

import com.entity.RenwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 承运任务
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class RenwuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 运输车辆
     */
    private Integer cheliangId;


    /**
     * 承运单号
     */
    private Integer yunshuchengbenId;


    /**
     * 承运时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date chengyunTime;


    /**
     * 接收时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date jieshouTime;


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
	 * 获取：运输车辆
	 */
    public Integer getCheliangId() {
        return cheliangId;
    }


    /**
	 * 设置：运输车辆
	 */
    public void setCheliangId(Integer cheliangId) {
        this.cheliangId = cheliangId;
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
	 * 获取：承运时间
	 */
    public Date getChengyunTime() {
        return chengyunTime;
    }


    /**
	 * 设置：承运时间
	 */
    public void setChengyunTime(Date chengyunTime) {
        this.chengyunTime = chengyunTime;
    }
    /**
	 * 获取：接收时间
	 */
    public Date getJieshouTime() {
        return jieshouTime;
    }


    /**
	 * 设置：接收时间
	 */
    public void setJieshouTime(Date jieshouTime) {
        this.jieshouTime = jieshouTime;
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
