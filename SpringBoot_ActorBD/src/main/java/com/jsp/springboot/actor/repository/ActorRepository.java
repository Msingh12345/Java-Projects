package com.jsp.springboot.actor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.springboot.actor.entity.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer>{
	

}
