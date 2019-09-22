/**
* @项目名称: J1012Web
* @文件名称: CreditService.java
* @Date: 2019年7月29日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.service;

import java.util.List;
import java.util.Map;

import com.ychs.uol.model.Credit;

/**
 * 学分 Service 接口
 * 
 * @author: liuhao
 * @version 1.0
 */
public interface CreditService {
    /**
     * 添加学分
     * 
     * @param credit 封装的学分对象
     * @return 添加成功返回1, 失败返回0
     */
    public int addCredit(Credit credit);

    /**
     * 根据姓名查询学分
     * 
     * @param map 查询条件
     * @return 查询到的学生信息集合
     */
    public List<Credit> selectCredit(Map<String, Object> map);
}
