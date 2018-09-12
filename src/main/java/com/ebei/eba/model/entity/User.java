
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
 * 用户表
 * </p>
 *  自动生成 2018-09-03
 * @author JiangP
 * @since 2018-09-03
 */
@TableName("iot_user")
@ApiModel("用户表User")
public class User extends Model<User> {

    /** 用户Id */
    @ApiModelProperty(hidden=true)
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;
    /** 登录账号 */
    private String userAccount;
    /** 用户名 */
    private String userName;
    /** 密码 */
    private String password;
    /** 电话 */
    private String telephone;
    /** 0-男,1-女 */
    private String sex;
    /** 备注 */
    private String remark;
    /** 工号 */
    private String jobNumber;
    /** 公司Id */
    private String companyId;
    /** 管理员标识（0:否 1:是） */
    private String isAdmin;
    /** 角色Id */
    private String roleId;
    /** 消息推送（0:否 1:是） */
    private String appPushFlag;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getAppPushFlag() {
        return appPushFlag;
    }

    public void setAppPushFlag(String appPushFlag) {
        this.appPushFlag = appPushFlag;
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
        return "User{" +
        ", userId=" + userId +
        ", userAccount=" + userAccount +
        ", userName=" + userName +
        ", password=" + password +
        ", telephone=" + telephone +
        ", sex=" + sex +
        ", remark=" + remark +
        ", jobNumber=" + jobNumber +
        ", companyId=" + companyId +
        ", isAdmin=" + isAdmin +
        ", roleId=" + roleId +
        ", appPushFlag=" + appPushFlag +
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
