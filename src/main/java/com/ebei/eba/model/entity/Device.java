
package com.ebei.eba.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** auto code version 1.4
 * <p>
 * 设备表
 * </p>
 *  自动生成 2018-09-10
 * @author JiangP
 * @since 2018-09-10
 */
@TableName("iot_device")
@ApiModel("设备表Device")
public class Device extends Model<Device> {

    /** 设备Id(主键) */
    @ApiModelProperty(hidden=true)
    @TableId(value = "device_id", type = IdType.AUTO)
    private String deviceId;
    /** 设备级别 */
    private String levelId;
    /** 设备名称 */
    private String deviceName;
    /** 设备编码 */
    private String deviceCode;
    /** 房间Id */
    private String roomId;
    /** 项目Id */
    private String projectId;
    /** 0-删除,1-有效 */
    @ApiModelProperty(hidden=true)
    @TableLogic
    private Integer state;
    /** 创建者 */
    @ApiModelProperty(hidden=true)
    private String creator;
    /** 创建时间 */
    @ApiModelProperty(hidden=true)
    private Date createDate;
    /** 操作者 */
    private String operator;
    /** 操作时间 */
    @ApiModelProperty(hidden=true)
    private Date operateDate;
    @ApiModelProperty(hidden=true)
    @TableField(exist=false)
    private Map<String,Object> extMap = new HashMap<String,Object>();
    public Map<String, Object> getExtMap() {
        return extMap;
    }
    public void setExtMap(Map<String, Object> extMap) {
        this.extMap = extMap;
    }
    public void putExt(String key,Object value) {
        this.extMap.put(key,value);
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(Date operateDate) {
        this.operateDate = operateDate;
    }

    @Override
    public String toString() {
        return "Device{" +
        ", deviceId=" + deviceId +
        ", levelId=" + levelId +
        ", deviceName=" + deviceName +
        ", deviceCode=" + deviceCode +
        ", roomId=" + roomId +
        ", projectId=" + projectId +
        ", state=" + state +
        ", creator=" + creator +
        ", createDate=" + createDate +
        ", operator=" + operator +
        ", operateDate=" + operateDate +
        "}";
    }

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return null;
	}
}
