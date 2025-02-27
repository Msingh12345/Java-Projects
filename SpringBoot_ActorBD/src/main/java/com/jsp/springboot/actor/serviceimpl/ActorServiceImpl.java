package com.jsp.springboot.actor.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jsp.springboot.actor.entity.Actor;
import com.jsp.springboot.actor.repository.ActorRepository;
import com.jsp.springboot.actor.service.ActorService;

public class ActorServiceImpl implements ActorService  {
	@Autowired
	private ActorRepository actorRepository;
	
	@Override
	public Actor addActor(Actor actor) {
		return actorRepository.save(actor);
	}

	
	@Override
	public List<Actor> findAllActors(){
		List<Actor> actors=actorRepository.findAll();
		if(actors.isEmpty()) {
			return null;
		}else {
			return actors;
		}
	}
}
