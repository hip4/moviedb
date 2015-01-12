package ch.bfh.ti.aimlessweeknight.moviedb.rest.controller;

import ch.bfh.ti.aimlessweeknight.moviedb.service.StudioService;
import ch.bfh.ti.aimlessweeknight.moviedb.service.dto.StudioDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Collection;


@Controller
@RequestMapping("/studios")
public class StudioController {

	@Inject
	private StudioService studioService;

	/**
	 * Create
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public StudioDTO createStudio(@RequestBody StudioDTO studio) {
		StudioDTO createdStudio = studioService.create(studio);
		System.out.println("Studio created with id = " + createdStudio.getId());
		return createdStudio;
	}

	/**
	 * ReadAll
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<StudioDTO> getStudios() {
		System.out.println("Collection of Studio requested");
		return studioService.list();
	}

	/**
	 * Read
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public StudioDTO getStudio(@PathVariable long id) {
		System.out.println("Studio requested with id = " + id);
		return studioService.read(id);
	}

	/**
	 * Update
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	@ResponseBody
	public StudioDTO updateStudio(@RequestBody StudioDTO studio, @PathVariable long id) {
		StudioDTO updatedStudio = studioService.update(studio);
		System.out.println("Studio updated with id = " + updatedStudio.getId());
		return updatedStudio;
	}

	/**
	 * Delete
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteStudio(@PathVariable long id) {
		StudioDTO studio = studioService.read(id);
		studioService.delete(studio);
		System.out.println("Delete Studio with id = " + id);
	}
}
