package com.skilldistillery.nonbucketlist.services;

import java.util.List;

import com.skilldistillery.nonbucketlist.entities.Bucket;

public interface BucketService {

	public List<Bucket> findAll();

	public Bucket findById(int id);

	public Bucket update(int id, Bucket buck);

	public Bucket create(Bucket buck);

	public Boolean delete(int id);

}
