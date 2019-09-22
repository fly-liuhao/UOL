/**
* @项目名称: J1012Web
* @文件名称: CourseMemberService.java
* @Date: 2019年7月29日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.service;

import java.util.List;
import java.util.Map;

import com.ychs.uol.model.CourseMember;

/**
 * 公开课成员Service接口
 * 
 * @author: liuhao
 * @version 1.0
 */
public interface CourseMemberService {
    /**
     * 登记公开课人员
     * 
     * @param courseMember 封装的公开课人员对象
     * @return 添加成功返回1,失败返回0
     */
    public int addCourseMember(CourseMember courseMember);

    /**
     * 查询参加的公开课人员
     * 
     * @param map 查询条件
     * @return 查询出的公开课人员集合
     */
    public List<CourseMember> selectCourseMember(Map<String, Object> map);
}
