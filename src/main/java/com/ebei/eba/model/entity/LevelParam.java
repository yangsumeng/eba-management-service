
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
 * 级别参数
 * </p>
 *  自动生成 2018-09-03
 * @author JiangP
 * @since 2018-09-03
 */
@TableName("iot_level_param")
@ApiModel("级别参数LevelParam")
public class LevelParam extends Model<LevelParam> {

    /** 参数Id */
    @ApiModelProperty(hidden=true)
    @TableId(value = "param_id", type = IdType.AUTO)
    private Long paramId;
    /** 设备级别 */
    private Long levelId;
    /** 参数名称 */
    private String paramName;
    /** 参数编码 */
    private String paramCode;
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

    public Long getParamId() {
        return paramId;
    }

    public void setParamId(Long paramId) {
        this.paramId = paramId;
    }

    public Long getLevelId() {
        return levelId;
    }

    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamCode() {
        return paramCode;
    }

    public void setParamCode(String paramCode) {
        this.paramCode = paramCode;
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
        return "LevelParam{" +
        ", paramId=" + paramId +
        ", levelId=" + levelId +
        ", paramName=" + paramName +
        ", paramCode=" + paramCode +
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
