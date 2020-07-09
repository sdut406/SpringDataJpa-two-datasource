package com.xing.springDataJpa.two;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * 用户表
 *
 * @author l
 * @since 2020-07-03
 */
@Repository
public interface TwoRepository extends JpaRepository<TwoEntity, String> {
}
