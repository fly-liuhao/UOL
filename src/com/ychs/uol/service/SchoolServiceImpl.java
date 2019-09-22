/**
* @项目名称: J1012Web
* @文件名称: SchoolServiceImpl.java
* @Date: 2019年7月28日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ychs.uol.dao.SchoolDao;
import com.ychs.uol.model.School;

/**
 * 
 * @author: liuhao
 * @version 1.0
 */
public class SchoolServiceImpl implements SchoolService {
    SchoolDao schoolDao = new SchoolDao();

    @Override
    public int addSchool(School school) {
        return schoolDao.insertSchool(school);
    }

    @Override
    public List<School> selectSchool(Map<String, Object> map) {
        return schoolDao.selectSchool(map);
    }

    @Override
    public List<School> selectAllSchool() {
        Map<String, Object> map = new HashMap<String, Object>();
        return schoolDao.selectSchool(map);
    }
    

}
