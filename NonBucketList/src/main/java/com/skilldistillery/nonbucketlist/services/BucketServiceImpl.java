package com.skilldistillery.nonbucketlist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.nonbucketlist.entities.Bucket;
import com.skilldistillery.nonbucketlist.repositories.BucketRepository;

@Service
public class BucketServiceImpl implements BucketService {

	@Autowired
	private BucketRepository repo;

	@Override
	public List<Bucket> findAll() {
		return repo.findAll();
	}

	@Override
	public Bucket findById(int id) {
		return repo.findById(id).get();
	}

	@Override
	public Bucket create(Bucket buck) {
		return repo.saveAndFlush(buck);
	}

	@Override
	public Bucket update(int id, Bucket buck) {
		Optional<Bucket> opt = repo.findById(id);
		Bucket managedPost = null;
		if (opt.isPresent()) {
			managedPost = opt.get();
			managedPost.setActive(buck.isActive());
			managedPost.setActivity(buck.getActivity());
			managedPost.setDesc(buck.getDesc());
			managedPost.setHowExperience(buck.getHowExperience());
			managedPost.setHowHappened(buck.getHowHappened());
			managedPost.setLevelHate(buck.getLevelHate());
			repo.saveAndFlush(managedPost);
		}
		return managedPost;
	}

	@Override
	public Boolean delete(int id) {
		boolean deleted = false;
		Optional<Bucket> opt = repo.findById(id);
		if (opt.isPresent()) {
			Bucket buck = opt.get();
			if (buck.getId() == id) {
				repo.deleteById(id);
				deleted = true;
			}
		}
		return deleted;
	}
}
