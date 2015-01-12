package ch.bfh.ti.aimlessweeknight.moviedb.service.test;

import ch.bfh.ti.aimlessweeknight.moviedb.service.GenreService;
import ch.bfh.ti.aimlessweeknight.moviedb.service.MovieService;
import ch.bfh.ti.aimlessweeknight.moviedb.service.dto.GenreDTO;
import ch.bfh.ti.aimlessweeknight.moviedb.service.dto.MovieDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/serviceContext.xml")
public class MovieServiceIT {

	@Inject
	private MovieService movieService;

	@Test
	public void test() {

		// Create
		MovieDTO newMovie = new MovieDTO();
		newMovie.setOriginalTitle("Antz");
		newMovie = movieService.create(newMovie);

		// Read
		MovieDTO readMovie = movieService.read(newMovie.getId());
		Assert.assertTrue(newMovie.getOriginalTitle().equals(readMovie.getOriginalTitle()));

		// Update
		readMovie.setOriginalTitle("A Bug's Life");
		readMovie = movieService.update(readMovie);
		MovieDTO updatedMovie = movieService.read(readMovie.getId());
		Assert.assertTrue(readMovie.getOriginalTitle().equals(updatedMovie.getOriginalTitle()));

		// Delete
		movieService.delete(updatedMovie);
		MovieDTO deletedMovie = movieService.read(readMovie.getId());
		Assert.assertNull(deletedMovie);
	}

}
