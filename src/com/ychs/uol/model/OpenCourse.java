/**
* @项目名称: UOLMyBatis
* @文件名称: OpenCourse.java
* @Date: 2019年7月23日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.model;

/**
 * 公开课实体类
 * 
 * @author: liuhao
 * @version 1.0
 */
public class OpenCourse {
    private String courseDate;
    private String courseName;
    private String speakerName;
    private String organizerName;
    private String place;
    private String school;
    private String department;
    private String grade;
    private String explain;
    private String remark;

    public OpenCourse() {
        super();
    }

    public OpenCourse(String courseDate, String courseName, String speakerName, String organizerName, String place,
            String school, String department, String grade, String explain, String remark) {
        super();
        this.courseDate = courseDate;
        this.courseName = courseName;
        this.speakerName = speakerName;
        this.organizerName = organizerName;
        this.place = place;
        this.school = school;
        this.department = department;
        this.grade = grade;
        this.explain = explain;
        this.remark = remark;
    }

    public String getCourseDate() {
        return courseDate;
    }

    public void setCourseDate(String courseDate) {
        this.courseDate = courseDate;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getSpeakerName() {
        return speakerName;
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "OpenCourse [courseDate=" + courseDate + ", courseName=" + courseName + ", speakerName=" + speakerName
                + ", organizerName=" + organizerName + ", place=" + place + ", school=" + school + ", department="
                + department + ", grade=" + grade + ", explain=" + explain + ", remark=" + remark + "]";
    }

}
