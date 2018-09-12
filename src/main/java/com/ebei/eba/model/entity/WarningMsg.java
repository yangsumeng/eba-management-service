
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
 * 告警消息模板
 * </p>
 *  自动生成 2018-09-10
 * @author JiangP
 * @since 2018-09-10
 */
@TableName("iot_warning_msg")
@ApiModel("告警消息模板WarningMsg")
public class WarningMsg extends Model<WarningMsg> {

    /** 消息模板Id */
    @ApiModelProperty(hidden=true)
    @TableId(value = "message_id", type = IdType.AUTO)
    private Long messageId;
    /** 设备属性Id */
    private String paramDetailId;
    /** 告警消息内容 */
    private String messageInfo;
    /** 单位 */
    private String unit;
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

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getParamDetailId() {
        return paramDetailId;
    }

    public void setParamDetailId(String paramDetailId) {
        this.paramDetailId = paramDetailId;
    }

    public String getMessageInfo() {
        return messageInfo;
    }

    public void setMessageInfo(String messageInfo) {
        this.messageInfo = messageInfo;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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
        return "WarningMsg{" +
        ", messageId=" + messageId +
        ", paramDetailId=" + paramDetailId +
        ", messageInfo=" + messageInfo +
        ", unit=" + unit +
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
