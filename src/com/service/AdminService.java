package com.service;

import com.po.Admin;

/**
 * 管理员service层接口
 */
public interface AdminService {
    //通过账号和密码查询
    public Admin CheckLogin(String username, String password);
}
