/**
* @项目名称: J1012Web
* @文件名称: User.java
* @Date: 2019年7月28日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.model;

/**
 * 用户实体类
 * 
 * @author: liuhao
 * @version 1.0
 */
public class User {
    private String userId;
    private String userName;
    private String userPwd;
    private String realName;
    private String sex;
    private String job;
    private String remark;
    private String status = "1";

    public User() {
        super();
    }

    public User(String userName, String userPwd, String realName, String sex, String job, String remark,
            String status) {
        super();
        this.userName = userName;
        this.userPwd = userPwd;
        this.realName = realName;
        this.sex = sex;
        this.job = job;
        this.remark = remark;
        this.status = status;
    }

    public User(String userName, String userPwd, String realName, String sex, String job, String remark) {
        super();
        this.userName = userName;
        this.userPwd = userPwd;
        this.realName = realName;
        this.sex = sex;
        this.job = job;
        this.remark = remark;
    }

    public User(String userId, String userName, String userPwd, String realName, String sex, String job, String remark,
            String status) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.realName = realName;
        this.sex = sex;
        this.job = job;
        this.remark = remark;
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", realName=" + realName
                + ", sex=" + sex + ", job=" + job + ", remark=" + remark + ", status=" + status + "]";
    }

}
