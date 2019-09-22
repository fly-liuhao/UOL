/**
* @项目名称: UOLMyBatis
* @文件名称: CourseMember.java
* @Date: 2019年7月23日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.model;

/**
 * 公开课成员实体类
 * 
 * @author: liuhao
 * @version 1.0
 */
public class CourseMember {

    private String memberId;
    private String courseDate;
    private String memberName;
    private String sex;
    private String school;
    private String department;
    private String grade;
    private String phoneNumber;
    private String email;

    public CourseMember() {
        super();
    }

    public CourseMember(String memberId, String courseDate, String memberName, String sex, String school,
            String department, String grade, String phoneNumber, String email) {
        super();
        this.memberId = memberId;
        this.courseDate = courseDate;
        this.memberName = memberName;
        this.sex = sex;
        this.school = school;
        this.department = department;
        this.grade = grade;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getCourseDate() {
        return courseDate;
    }

    public void setCourseDate(String courseDate) {
        this.courseDate = courseDate;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CourseMember [memberId=" + memberId + ", courseDate=" + courseDate + ", memberName=" + memberName
                + ", sex=" + sex + ", school=" + school + ", department=" + department + ", grade=" + grade
                + ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
    }

}
