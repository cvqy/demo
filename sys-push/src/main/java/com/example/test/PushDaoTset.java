package com.example.test;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner; 

import com.example.dao.PushDao;
import com.example.pojo.Push;

/**  
 *
 * <p>@开发版本  	：1.0</p>
 *
 * <p>@Copyright   :abyss-xd @ 2021 </p>
 *
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PushDaoTset {

	@Autowired
	private PushDao pushDao;
	
	@Test
	public void testFindById() { 
		Optional<Push> push = pushDao.findById(1); 
		System.out.println(push.get());
	}
}
