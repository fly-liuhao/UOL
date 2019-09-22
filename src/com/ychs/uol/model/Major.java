/**
* @项目名称: UOLMyBatis
* @文件名称: Major.java
* @Date: 2019年7月23日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.model;

/**
 * 专业实体类
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Major {
    private String majorId;
    private String majorName;
    private String majorInfo;
    private String deptId;
    private String schoolId;

    public Major() {
        super();
    }

    public Major(String majorName, String majorInfo, String deptId, String schoolId) {
        super();
        this.majorName = majorName;
        this.majorInfo = majorInfo;
        this.deptId = deptId;
        this.schoolId = schoolId;
    }

    public Major(String majorId, String majorName, String majorInfo, String deptId, String schoolId) {
        super();
        this.majorId = majorId;
        this.majorName = majorName;
        this.majorInfo = majorInfo;
        this.deptId = deptId;
        this.schoolId = schoolId;
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getMajorInfo() {
        return majorInfo;
    }

    public void setMajorInfo(String majorInfo) {
        this.majorInfo = majorInfo;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
    

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    @Override
    public String toString() {
        return "Major [majorId=" + majorId + ", majorName=" + majorName + ", majorInfo=" + majorInfo + ", deptId="
                + deptId + ", schoolId=" + schoolId + "]";
    }



}
