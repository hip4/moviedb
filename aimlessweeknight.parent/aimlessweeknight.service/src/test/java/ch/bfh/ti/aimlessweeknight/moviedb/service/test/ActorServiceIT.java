package ch.bfh.ti.aimlessweeknight.moviedb.service.test;

import javax.inject.Inject;

import ch.bfh.ti.aimlessweeknight.moviedb.service.dto.ActorDTO;
import ch.bfh.ti.aimlessweeknight.moviedb.service.ActorService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/serviceContext.xml")
public class ActorServiceIT {

	@Inject
	private ActorService actorService;

	@Test
	public void test() {

		// Create
		ActorDTO newActor = new ActorDTO();
		newActor.setName("William Bradley Pitt");
		newActor = actorService.create(newActor);

		// Read
		ActorDTO readActor = actorService.read(newActor.getId());
		Assert.assertTrue(newActor.getName().equals(readActor.getName()));

		// Update
		readActor.setName("Brad Pitt");
		readActor = actorService.update(readActor);
		ActorDTO updatedActor = actorService.read(readActor.getId());
		Assert.assertTrue(readActor.getName().equals(updatedActor.getName()));

		// Delete
		actorService.delete(updatedActor);
		ActorDTO deletedActor = actorService.read(readActor.getId());
		Assert.assertNull(deletedActor);
	}

}
