package com.dao;

import com.po.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminDao {
    //验证的登陆
    public Admin CheckLogin(@Param("username") String username, @Param("password") String password);

}
