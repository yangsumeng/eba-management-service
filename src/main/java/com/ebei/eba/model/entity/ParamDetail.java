
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
 * 设备属性详情
 * </p>
 *  自动生成 2018-09-10
 * @author JiangP
 * @since 2018-09-10
 */
@TableName("iot_param_detail")
@ApiModel("设备属性详情ParamDetail")
public class ParamDetail extends Model<ParamDetail> {

    /** 详情Id(主键) */
    @ApiModelProperty(hidden=true)
    @TableId(value = "detail_id", type = IdType.AUTO)
    private String detailId;
    /** 上限报警值 */
    private String upAlarmVal;
    /** 下限报警值 */
    private String downAlarmVal;
    /** 参数Id */
    private String paramId;
    /** 参数编码 */
    private String paramNo;
    /** 采集地址 */
    private String collectAddress;
    /** 设备Id */
    private String deviceId;
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

    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    public String getUpAlarmVal() {
        return upAlarmVal;
    }

    public void setUpAlarmVal(String upAlarmVal) {
        this.upAlarmVal = upAlarmVal;
    }

    public String getDownAlarmVal() {
        return downAlarmVal;
    }

    public void setDownAlarmVal(String downAlarmVal) {
        this.downAlarmVal = downAlarmVal;
    }

    public String getParamId() {
        return paramId;
    }

    public void setParamId(String paramId) {
        this.paramId = paramId;
    }

    public String getParamNo() {
        return paramNo;
    }

    public void setParamNo(String paramNo) {
        this.paramNo = paramNo;
    }

    public String getCollectAddress() {
        return collectAddress;
    }

    public void setCollectAddress(String collectAddress) {
        this.collectAddress = collectAddress;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
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
        return "ParamDetail{" +
        ", detailId=" + detailId +
        ", upAlarmVal=" + upAlarmVal +
        ", downAlarmVal=" + downAlarmVal +
        ", paramId=" + paramId +
        ", paramNo=" + paramNo +
        ", collectAddress=" + collectAddress +
        ", deviceId=" + deviceId +
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
