package com.lxm.user.center.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lxm.user.domain.UserInfo;

/**
 * 实现CRUD
 * @author Administrator
 *
 */

@Repository
public interface UserDao extends JpaRepository<UserInfo, Long>{

}
