package com.cognizant.ormlearn.service;

import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.model.Skill;

@Transactional
public interface SkillService {
	
	public Skill get(int id);
	
	public void save(Skill skill);
}