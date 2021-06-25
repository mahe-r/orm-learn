package com.cognizant.ormlearn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.repository.SkillRepository;
import com.cognizant.ormlearn.service.SkillService;

@Service("skillService")
public class SkillServiceImpl implements SkillService{
	
	@Autowired
	private SkillRepository repository;

	@Override
	public Skill get(int id) {
		return repository.findById(id).get();
	}

	@Override
	public void save(Skill skill) {
		repository.save(skill);
	}
}