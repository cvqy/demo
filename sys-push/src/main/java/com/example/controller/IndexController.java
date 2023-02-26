package com.example.controller;

import java.util.HashMap; 
import java.util.Map;

import com.example.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.repository.StatusRepository;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@RestController
@Slf4j
@SuppressWarnings(value = {"rawtypes","unchecked"})
public class IndexController {
	
	@Autowired
	private StatusRepository statusRepository;
 

	@PostMapping(path = "/update/title")
	public Status updateStatus(@RequestBody Status status) {
		return statusRepository.save(status);
	}

	@GetMapping(path = "/stream/push", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<ServerSentEvent<Object>> stream_title() {
		Map<Object, Object> map =new HashMap<Object, Object>(); 
		map.put("msg", statusRepository.findById(1));
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
