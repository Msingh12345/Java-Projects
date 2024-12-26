package com.jsp.springboot.actor.service;

import java.util.List;

import com.jsp.springboot.actor.entity.Actor;

public interface ActorService {

	Actor addActor(Actor actor);

	List<Actor> findAllActors();

}
