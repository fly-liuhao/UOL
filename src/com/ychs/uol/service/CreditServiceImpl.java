/**
* @项目名称: J1012Web
* @文件名称: CreditServiceImpl.java
* @Date: 2019年7月29日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.service;

import java.util.List;
import java.util.Map;

import com.ychs.uol.dao.CreditDao;
import com.ychs.uol.model.Credit;

/**
 * 学分 Service 接口实现类
 * 
 * @author: liuhao
 * @version 1.0
 */
public class CreditServiceImpl implements CreditService {
    CreditDao creditDao = new CreditDao();

    @Override
    public int addCredit(Credit credit) {
        return creditDao.insertCredit(credit);
    }

    @Override
    public List<Credit> selectCredit(Map<String, Object> map) {
        return creditDao.selectCredit(map);
    }

}
