/**
* @项目名称: UOLMyBatis
* @文件名称: LabMember.java
* @Date: 2019年7月23日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.model;

/**
 * 实验室成员实体类
 * 
 * @author: liuhao
 * @version 1.0
 */
public class LabMember {
    private String memberName;
    private String memberId;
    private String sex;
    private String grade;
    private String birthPlace;
    private String phoneNumber;
    private String email;
    private String schoolName = null;
    private String schoolId;
    private String deptName = null;
    private String deptId;
    private String majorName = null;
    private String majorId;
    private String schoolJob;
    private String joinDate;
    private String certificate;
    private String status;
    private String labJob;
    private String trainning;
    private String skill;
    private String remark;

    public LabMember() {
        super();
    }

    public LabMember(String memberName, String memberId, String sex, String grade, String birthPlace,
            String phoneNumber, String email, String schoolId, String deptId, String majorId, String schoolJob,
            String joinDate, String certificate, String status, String labJob, String trainning, String skill,
            String remark) {
        super();
        this.memberName = memberName;
        this.memberId = memberId;
        this.sex = sex;
        this.grade = grade;
        this.birthPlace = birthPlace;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.schoolId = schoolId;
        this.deptId = deptId;
        this.majorId = majorId;
        this.schoolJob = schoolJob;
        this.joinDate = joinDate;
        this.certificate = certificate;
        this.status = status;
        this.labJob = labJob;
        this.trainning = trainning;
        this.skill = skill;
        this.remark = remark;
    }
  
    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
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

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public String getSchoolJob() {
        return schoolJob;
    }

    public void setSchoolJob(String schoolJob) {
        this.schoolJob = schoolJob;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLabJob() {
        return labJob;
    }

    public void setLabJob(String labJob) {
        this.labJob = labJob;
    }

    public String getTrainning() {
        return trainning;
    }

    public void setTrainning(String trainning) {
        this.trainning = trainning;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "LabMember [memberName=" + memberName + ", memberId=" + memberId + ", sex=" + sex + ", grade=" + grade
                + ", birthPlace=" + birthPlace + ", phoneNumber=" + phoneNumber + ", email=" + email + ", schoolName="
                + schoolName + ", schoolId=" + schoolId + ", deptName=" + deptName + ", deptId=" + deptId
                + ", majorName=" + majorName + ", majorId=" + majorId + ", schoolJob=" + schoolJob + ", joinDate="
                + joinDate + ", certificate=" + certificate + ", status=" + status + ", labJob=" + labJob
                + ", trainning=" + trainning + ", skill=" + skill + ", remark=" + remark + "]";
    }

}
