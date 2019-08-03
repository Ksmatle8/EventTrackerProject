package com.skilldistillery.nonbucketlist.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class BucketTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Bucket list;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("NonBucketListPU");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		list = em.find(Bucket.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		list = null;
	}

	@Disabled
	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void test_List_Entity() {
		assertEquals(1, list.getId());
	}

}
