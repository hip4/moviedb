package ch.bfh.ti.aimlessweeknight.moviedb.service.test;

import ch.bfh.ti.aimlessweeknight.moviedb.service.ActorService;
import ch.bfh.ti.aimlessweeknight.moviedb.service.GenreService;
import ch.bfh.ti.aimlessweeknight.moviedb.service.dto.ActorDTO;
import ch.bfh.ti.aimlessweeknight.moviedb.service.dto.GenreDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/serviceContext.xml")
public class GenreServiceIT {

	@Inject
	private GenreService genreService;

	@Test
	public void test() {

		// Create
		GenreDTO newGenre = new GenreDTO();
		newGenre.setLabel("Drama");
		newGenre = genreService.create(newGenre);

		// Read
		GenreDTO readGenre = genreService.read(newGenre.getId());
		Assert.assertTrue(newGenre.getLabel().equals(readGenre.getLabel()));

		// Update
		readGenre.setLabel("Horror");
		readGenre = genreService.update(readGenre);
		GenreDTO updatedGenre = genreService.read(readGenre.getId());
		Assert.assertTrue(readGenre.getLabel().equals(updatedGenre.getLabel()));

		// Delete
		genreService.delete(updatedGenre);
		GenreDTO deletedGenre = genreService.read(readGenre.getId());
		Assert.assertNull(deletedGenre);
	}

}
