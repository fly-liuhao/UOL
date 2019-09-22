/**
* @项目名称: UOLMyBatis
* @文件名称: SchoolMapper.java
* @Date: 2019年7月23日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.mapper;

import java.util.List;
import java.util.Map;

import com.sun.org.apache.bcel.internal.generic.Select;
import com.ychs.uol.model.School;

/**
 * 
 * @author: liuhao
 * @version 1.0
 */
public interface SchoolMapper {

    /**
     * 添加院校
     * 
     * @param school 封装的学校对象
     * @return 添加成功返回1,失败返回0
     */
    public int insertSchool(School school);

    /**
     * 删除学校
     * 
     * @param schoolName 学校名称
     * @return 删除成功返回1， 失败返回0
     */
    public int deleteSchool(String schoolName);

    /**
     * 删除学校,通过触发器
     * 
     * @param schoolName 学校名称
     * @return 删除成功返回1， 失败返回0
     */
    public int deleteSchoolByTrigger(String schoolName);

    /**
     * 查询学校
     * 
     * @param map 查询条件
     * @return 查询到的学校对象集合
     */
    public List<School> selectSchool(Map<String, Object> map);

}
