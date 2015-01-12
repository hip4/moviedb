package ch.bfh.ti.aimlessweeknight.moviedb.service.test;

import ch.bfh.ti.aimlessweeknight.moviedb.service.MovieService;
import ch.bfh.ti.aimlessweeknight.moviedb.service.PossessionService;
import ch.bfh.ti.aimlessweeknight.moviedb.service.UserService;
import ch.bfh.ti.aimlessweeknight.moviedb.service.dto.MovieDTO;
import ch.bfh.ti.aimlessweeknight.moviedb.service.dto.PossessionDTO;
import ch.bfh.ti.aimlessweeknight.moviedb.service.dto.UserDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/serviceContext.xml")
public class PossessionServiceIT {

	@Inject
	private PossessionService possessionService;

	@Test
	public void test() {

		// Create
		PossessionDTO newPossession = new PossessionDTO();
		newPossession.setPhysicalLocation("location0001");
		newPossession = possessionService.create(newPossession);

		// Read
		PossessionDTO readPossession = possessionService.read(newPossession.getId());
		Assert.assertTrue(newPossession.getPhysicalLocation().equals(readPossession.getPhysicalLocation()));

		// Update
		readPossession.setPhysicalLocation("location0002");
		readPossession = possessionService.update(readPossession);
		PossessionDTO updatedPossession = possessionService.read(readPossession.getId());
		Assert.assertTrue(readPossession.getPhysicalLocation().equals(updatedPossession.getPhysicalLocation()));

		// Delete
		possessionService.delete(updatedPossession);
		PossessionDTO deletedPossession = possessionService.read(readPossession.getId());
		Assert.assertNull(deletedPossession);
	}

}
