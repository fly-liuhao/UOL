/**
* @项目名称: UOL
* @文件名称: Info.java
* @Date: 2019年7月18日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.model;

/**
 * 封装所有专业的隶属关系
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Info {
    private String schoolName;
    private String deptName;
    private String majorName;

    public Info() {
        super();
    }

    public Info(String schoolName, String deptName, String majorName) {
        super();
        this.schoolName = schoolName;
        this.deptName = deptName;
        this.majorName = majorName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    @Override
    public String toString() {
        return "Info [schoolName=" + schoolName + ", deptName=" + deptName + ", majorName=" + majorName + "]";
    }

}
