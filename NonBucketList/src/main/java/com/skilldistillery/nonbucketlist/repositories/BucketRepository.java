package com.skilldistillery.nonbucketlist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.nonbucketlist.entities.Bucket;

public interface BucketRepository extends JpaRepository<Bucket, Integer>{
	

}
