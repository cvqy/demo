package com.example.dao;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.pojo.Push;

/**  
 * <p>@开发版本  	：1.0</p>
 *
 * <p>@Copyright   :abyss-xd @ 2021 </p>
 *
 */
@Repository
public interface PushDao extends JpaRepository<Push,Integer>, JpaSpecificationExecutor<Push> {

}
