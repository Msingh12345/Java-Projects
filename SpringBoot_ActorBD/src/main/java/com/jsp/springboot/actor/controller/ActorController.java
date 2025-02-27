package com.jsp.springboot.actor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsp.springboot.actor.entity.Actor;
import com.jsp.springboot.actor.service.ActorService;


@Controller
@ResponseBody
public class ActorController {

	@Autowired
	private ActorService actorSrvice;

	@RequestMapping(value = "/actors", method = RequestMethod.POST)
	public Actor addActor(@RequestBody Actor actor) {
		return actorSrvice.addActor(actor);
	}
}
