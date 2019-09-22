/**
* @项目名称: UOLMyBatis
* @文件名称: Department.java
* @Date: 2019年7月23日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.model;

/**
 * 院系实体类
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Department {
    private String deptId;
    private String deptName;
    private String deptInfo;
    private String schoolId;

    public Department() {
        super();
    }

    public Department(String deptName, String deptInfo, String schoolId) {
        super();
        this.deptName = deptName;
        this.deptInfo = deptInfo;
        this.schoolId = schoolId;
    }

    public Department(String deptId, String deptName, String deptInfo, String schoolId) {
        super();
        this.deptId = deptId;
        this.deptName = deptName;
        this.deptInfo = deptInfo;
        this.schoolId = schoolId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptInfo() {
        return deptInfo;
    }

    public void setDeptInfo(String deptInfo) {
        this.deptInfo = deptInfo;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    @Override
    public String toString() {
        return "Department [deptId=" + deptId + ", deptName=" + deptName + ", deptInfo=" + deptInfo + ", schoolId="
                + schoolId + "]";
    }

}
