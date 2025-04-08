package com.entity.vo;

import com.entity.ShijiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 司机信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shiji")
public class ShijiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "ruzhi_time")
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

}
