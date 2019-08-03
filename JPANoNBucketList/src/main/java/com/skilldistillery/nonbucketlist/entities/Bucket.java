package com.skilldistillery.nonbucketlist.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bucket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String activity;
	
	@Column(name="description")
	private String desc;
	
	@Column(name="level_hate")
	private int levelHate;
	 
	private boolean active;
	
	@Column(name="how_happened")
	private String howHappened;
	
	@Column(name="how_experience")
	private String howExperience;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getLevelHate() {
		return levelHate;
	}

	public void setLevelHate(int levelHate) {
		this.levelHate = levelHate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getHowHappened() {
		return howHappened;
	}

	public void setHowHappened(String howHappened) {
		this.howHappened = howHappened;
	}

	public String getHowExperience() {
		return howExperience;
	}

	public void setHowExperience(String howExperience) {
		this.howExperience = howExperience;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bucket other = (Bucket) obj;
		if (active != other.active)
			return false;
		return true;
	}

	public Bucket() {
		super();
	}

	public Bucket(int id, String activity, String desc, int levelHate, boolean active, String howHappened,
			String howExperience) {
		super();
		this.id = id;
		this.activity = activity;
		this.desc = desc;
		this.levelHate = levelHate;
		this.active = active;
		this.howHappened = howHappened;
		this.howExperience = howExperience;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("List [id=").append(id).append(", activity=").append(activity).append(", desc=").append(desc)
				.append(", levelHate=").append(levelHate).append(", active=").append(active).append(", howHappened=")
				.append(howHappened).append(", howExperience=").append(howExperience).append("]");
		return builder.toString();
	}
	
	
}
