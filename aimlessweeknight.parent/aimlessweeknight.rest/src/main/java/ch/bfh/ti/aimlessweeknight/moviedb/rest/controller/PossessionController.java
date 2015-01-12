package ch.bfh.ti.aimlessweeknight.moviedb.rest.controller;

import ch.bfh.ti.aimlessweeknight.moviedb.service.PossessionService;
import ch.bfh.ti.aimlessweeknight.moviedb.service.dto.PossessionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Collection;


@Controller
@RequestMapping("/possessions")
public class PossessionController {

	@Inject
	private PossessionService possessionService;

	/**
	 * Create
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public PossessionDTO createPossession(@RequestBody PossessionDTO possession) {
		PossessionDTO createdPossession = possessionService.create(possession);
		System.out.println("Possession created with id = " + createdPossession.getId());
		return createdPossession;
	}

	/**
	 * ReadAll
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<PossessionDTO> getPossessions() {
		System.out.println("Collection of Possession requested");
		return possessionService.list();
	}

	/**
	 * Read
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public PossessionDTO getPossession(@PathVariable long id) {
		System.out.println("Possession requested with id = " + id);
		return possessionService.read(id);
	}

	/**
	 * Update
	 */
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public PossessionDTO updatePossession(@RequestBody PossessionDTO possession) {
		PossessionDTO updatedPossession = possessionService.update(possession);
		System.out.println("Possession updated with id = " + updatedPossession.getId());
		return updatedPossession;
	}

	/**
	 * Delete
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deletePossession(@PathVariable long id) {
		PossessionDTO possession = possessionService.read(id);
		possessionService.delete(possession);
		System.out.println("Delete Possession with id = " + id);
	}
}
