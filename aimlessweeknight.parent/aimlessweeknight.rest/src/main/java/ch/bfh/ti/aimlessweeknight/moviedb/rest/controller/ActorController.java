package ch.bfh.ti.aimlessweeknight.moviedb.rest.controller;

import java.util.Collection;

import javax.inject.Inject;

import ch.bfh.ti.aimlessweeknight.moviedb.service.ActorService;
import ch.bfh.ti.aimlessweeknight.moviedb.service.dto.ActorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;



@Controller
@RequestMapping("/actors")
public class ActorController {

	@Inject
	private ActorService actorService;

	/**
	 * Create
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ActorDTO createActor(@RequestBody ActorDTO actor) {
		ActorDTO createdActor = actorService.create(actor);
		System.out.println("Actor created with id = " + createdActor.getId());
		return createdActor;
	}

	/**
	 * ReadAll
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<ActorDTO> getActors() {
		System.out.println("Collection of Actor requested");
		return actorService.list();
	}

	/**
	 * Read
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public ActorDTO getActor(@PathVariable long id) {
		System.out.println("Actor requested with id = " + id);
		return actorService.read(id);
	}

	/**
	 * Update
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ActorDTO updateActor(@RequestBody ActorDTO actor, @PathVariable long id) {
		ActorDTO updatedActor = actorService.update(actor);
		System.out.println("Actor updated with id = " + updatedActor.getId());
		return updatedActor;
	}

	/**
	 * Delete
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteActor(@PathVariable long id) {
		ActorDTO actor = actorService.read(id);
		actorService.delete(actor);
		System.out.println("Delete Actor with id = " + id);
	}
}
