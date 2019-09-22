/**
* @项目名称: UOLMyBatis
* @文件名称: Credit.java
* @Date: 2019年7月23日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.model;

/**
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Credit {
    private String stuName;
    private String stuId;
    private String score;
    private String remark;

    public Credit() {
        super();
    }

    public Credit(String stuName, String stuId, String score, String remark) {
        super();
        this.stuName = stuName;
        this.stuId = stuId;
        this.score = score;
        this.remark = remark;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Credit [stuName=" + stuName + ", stuId=" + stuId + ", score=" + score + ", remark=" + remark + "]";
    }

}
