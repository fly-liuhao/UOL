/**
* @项目名称: J1012Web
* @文件名称: SchoolService.java
* @Date: 2019年7月28日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.service;

import java.util.List;
import java.util.Map;

import com.ychs.uol.model.School;

/**
 * 学校的Service接口
 * 
 * @author: liuhao
 * @version 1.0
 */
public interface SchoolService {

    /**
     * 添加院校
     * 
     * @param school 封装的学校对象
     * @return 添加成功返回1,失败返回0
     */
    public int addSchool(School school);
    
    /**
     * 查询学校
     * 
     * @param map 查询条件
     * @return 查询到的学校对象集合
     */
    public List<School> selectSchool(Map<String, Object> map);
    
    /**
     * 查询所有学校
     * 
     * @return 查询到的学校对象集合
     */
    public List<School> selectAllSchool();

}
