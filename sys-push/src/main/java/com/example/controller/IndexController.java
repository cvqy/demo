package com.example.controller;

import java.text.SimpleDateFormat; 
import java.util.Date;
import java.util.HashMap; 
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.PushDao;
import com.example.pojo.Push;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
/**  
 * <p>@开发版本  	：1.0</p>
 *
 * <p>@Copyright   :abyss-xd @ 2021 </p>
 *
 */
@RestController
@Slf4j
@SuppressWarnings(value = {"rawtypes","unchecked"})
public class IndexController {
	
	@Autowired
	private PushDao pushDao;
	
	@GetMapping("/index")
	public String index() {
		log.debug("程序启动 ==== {}", new Date());
		return "index" + "==" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
	}
 
	/**
	 * <p>@方法名描述	：模拟更新数据库数据 </p>
	 *
	 * @param title 标题
	 * @return
	 */
	@PostMapping(path = "/update/title")
	public Push update_title(@RequestBody Push push) { 
		return pushDao.save(push);
	}
	
	/**
	 * <p>@方法名描述	：EventSource 连接 </p>
	 *
	 * @return
	 */
	@GetMapping(path = "/stream/push", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<ServerSentEvent<Object>> stream_title() {
		Map<Object, Object> map =new HashMap<Object, Object>(); 
		map.put("msg", pushDao.findById(1));
		//结果要以stream流返回，注意的是，只能返回一条数据
		/**
		 * 这种会推送两条数据到前端，前端接受的是两条数据
		 * map.put("title", UserCache.cache.get("title"));
		 * map.put("code", UserCache.cache.get("title"));
		 * 
		 * 推送一条json数据实例：
		 * map.put("msg", pushDao.findById(1));
		 */
		Flux result = Flux.fromStream(map.entrySet().stream());
		return result;
	}
}
