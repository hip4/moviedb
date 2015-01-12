package ch.bfh.ti.aimlessweeknight.moviedb.rest.controller;

import ch.bfh.ti.aimlessweeknight.moviedb.service.MovieService;
import ch.bfh.ti.aimlessweeknight.moviedb.service.dto.MovieDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Collection;


@Controller
@RequestMapping("/movies")
public class MovieController {

	@Inject
	private MovieService movieService;

	/**
	 * Create
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public MovieDTO createMovie(@RequestBody MovieDTO movie) {
		MovieDTO createdMovie = movieService.create(movie);
		System.out.println("Movie created with id = " + createdMovie.getId());
		return createdMovie;
	}

	/**
	 * ReadAll
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<MovieDTO> getMovies() {
		System.out.println("Collection of Movie requested");
		return movieService.list();
	}

	/**
	 * Read
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public MovieDTO getMovie(@PathVariable long id) {
		System.out.println("Movie requested with id = " + id);
		return movieService.read(id);
	}

	/**
	 * Update
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	@ResponseBody
	public MovieDTO updateMovie(@RequestBody MovieDTO movie, @PathVariable long id) {
		MovieDTO updatedMovie = movieService.update(movie);
		System.out.println("Movie updated with id = " + updatedMovie.getId());
		return updatedMovie;
	}

	/**
	 * Delete
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteMovie(@PathVariable long id) {
		MovieDTO movie = movieService.read(id);
		movieService.delete(movie);
		System.out.println("Delete Movie with id = " + id);
	}
}
