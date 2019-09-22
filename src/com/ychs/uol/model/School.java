/**
* @项目名称: UOLMyBatis
* @文件名称: School.java
* @Date: 2019年7月23日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.model;

/**
 * 学校实体类
 * 
 * @author: liuhao
 * @version 1.0
 */
public class School {
    private String schoolId;
    private String schoolName;
    private String schoolInfo;

    public School() {
        super();
    }

    public School(String schoolName, String schoolInfo) {
        super();
        this.schoolName = schoolName;
        this.schoolInfo = schoolInfo;
    }

    public School(String schoolId, String schoolName, String schoolInfo) {
        super();
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.schoolInfo = schoolInfo;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolInfo() {
        return schoolInfo;
    }

    public void setSchoolInfo(String schoolInfo) {
        this.schoolInfo = schoolInfo;
    }

    @Override
    public String toString() {
        return "School [schoolId=" + schoolId + ", schoolName=" + schoolName + ", schoolInfo=" + schoolInfo + "]";
    }

}
