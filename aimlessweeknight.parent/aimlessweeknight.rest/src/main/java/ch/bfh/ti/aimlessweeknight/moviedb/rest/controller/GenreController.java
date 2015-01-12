package ch.bfh.ti.aimlessweeknight.moviedb.rest.controller;

import ch.bfh.ti.aimlessweeknight.moviedb.service.GenreService;
import ch.bfh.ti.aimlessweeknight.moviedb.service.dto.GenreDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Collection;


@Controller
@RequestMapping("/genres")
public class GenreController {

	@Inject
	private GenreService genreService;

	/**
	 * Create
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public GenreDTO createGenre(@RequestBody GenreDTO genre) {
		GenreDTO createdGenre = genreService.create(genre);
		System.out.println("Genre created with id = " + createdGenre.getId());
		return createdGenre;
	}

	/**
	 * ReadAll
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<GenreDTO> getGenres() {
		System.out.println("Collection of Genre requested");
		return genreService.list();
	}

	/**
	 * Read
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public GenreDTO getGenre(@PathVariable long id) {
		System.out.println("Genre requested with id = " + id);
		return genreService.read(id);
	}

	/**
	 * Update
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	@ResponseBody
	public GenreDTO updateGenre(@RequestBody GenreDTO genre, @PathVariable long id) {
		GenreDTO updatedGenre = genreService.update(genre);
		System.out.println("Genre updated with id = " + updatedGenre.getId());
		return updatedGenre;
	}

	/**
	 * Delete
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteGenre(@PathVariable long id) {
		GenreDTO genre = genreService.read(id);
		genreService.delete(genre);
		System.out.println("Delete Genre with id = " + id);
	}
}
