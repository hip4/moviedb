package ch.bfh.ti.aimlessweeknight.moviedb.service.test;

import ch.bfh.ti.aimlessweeknight.moviedb.service.MovieService;
import ch.bfh.ti.aimlessweeknight.moviedb.service.StudioService;
import ch.bfh.ti.aimlessweeknight.moviedb.service.dto.MovieDTO;
import ch.bfh.ti.aimlessweeknight.moviedb.service.dto.StudioDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/serviceContext.xml")
public class StudioServiceIT {

	@Inject
	private StudioService studioService;

	@Test
	public void test() {

		// Create
		StudioDTO newStudio = new StudioDTO();
		newStudio.setLabel("Pixar");
		newStudio = studioService.create(newStudio);

		// Read
		StudioDTO readStudio = studioService.read(newStudio.getId());
		Assert.assertTrue(newStudio.getLabel().equals(readStudio.getLabel()));

		// Update
		readStudio.setLabel("DreamWorks");
		readStudio = studioService.update(readStudio);
		StudioDTO updatedStudio = studioService.read(readStudio.getId());
		Assert.assertTrue(readStudio.getLabel().equals(updatedStudio.getLabel()));

		// Delete
		studioService.delete(updatedStudio);
		StudioDTO deletedStudio = studioService.read(readStudio.getId());
		Assert.assertNull(deletedStudio);
	}

}
