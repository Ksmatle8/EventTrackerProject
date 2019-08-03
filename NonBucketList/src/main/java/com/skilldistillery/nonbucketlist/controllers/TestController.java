package com.skilldistillery.nonbucketlist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.nonbucketlist.entities.Bucket;
import com.skilldistillery.nonbucketlist.services.BucketService;

@RestController
@RequestMapping("api")
public class TestController {
	
	
	@GetMapping("ping")
	public String ping() {
		return "pong";
	}
	
	@Autowired
	private BucketService svc;
	
	@GetMapping("bucket")
	public List<Bucket> findAll(){
		return svc.findAll();
	}
	
	@GetMapping("bucket/{id}")
	public Bucket findById(@PathVariable("id") int id) {
		return svc.findById(id);
	}
	
	@PostMapping("bucket")
	public Bucket create(@RequestBody Bucket buck) {
		return svc.create(buck);
	}
	
	@PutMapping("bucket/{id}")
	public Bucket update(@PathVariable("id") int id, @RequestBody Bucket buck) {
		return svc.update(id, buck);
	}
	
	@DeleteMapping("bucket/{id}")
	public Boolean delete(@PathVariable("id")int id) {
		return svc.delete(id);
	}
	
	
	
	
	

}
