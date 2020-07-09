package com.xing.springDataJpa.first;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * 用户表
 *
 * @author l
 * @since 2020-07-03
 */
@Repository
public interface FirstRepository extends JpaRepository<FirstEntity, String> {
}
