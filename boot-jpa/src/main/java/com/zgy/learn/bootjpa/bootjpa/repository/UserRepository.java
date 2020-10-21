package com.zgy.learn.bootjpa.bootjpa.repository;

import com.zgy.learn.bootjpa.bootjpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2019/12/19 2:29
 * @Modified by:
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
