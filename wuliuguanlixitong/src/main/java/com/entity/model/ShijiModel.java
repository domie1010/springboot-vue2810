package com.entity.model;

import com.entity.ShijiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 司机信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShijiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 司机名称
     */
    private String shijiName;


    /**
     * 驾照类型
     */
    private Integer jiazhaoTypes;


    /**
     * 入职时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date ruzhiTime;


    /**
     * 联系方式
     */
    private String shijiPhone;


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
	 * 获取：司机名称
	 */
    public String getShijiName() {
        return shijiName;
    }


    /**
	 * 设置：司机名称
	 */
    public void setShijiName(String shijiName) {
        this.shijiName = shijiName;
    }
    /**
	 * 获取：驾照类型
	 */
    public Integer getJiazhaoTypes() {
        return jiazhaoTypes;
    }


    /**
	 * 设置：驾照类型
	 */
    public void setJiazhaoTypes(Integer jiazhaoTypes) {
        this.jiazhaoTypes = jiazhaoTypes;
    }
    /**
	 * 获取：入职时间
	 */
    public Date getRuzhiTime() {
        return ruzhiTime;
    }


    /**
	 * 设置：入职时间
	 */
    public void setRuzhiTime(Date ruzhiTime) {
        this.ruzhiTime = ruzhiTime;
    }
    /**
	 * 获取：联系方式
	 */
    public String getShijiPhone() {
        return shijiPhone;
    }


    /**
	 * 设置：联系方式
	 */
    public void setShijiPhone(String shijiPhone) {
        this.shijiPhone = shijiPhone;
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
