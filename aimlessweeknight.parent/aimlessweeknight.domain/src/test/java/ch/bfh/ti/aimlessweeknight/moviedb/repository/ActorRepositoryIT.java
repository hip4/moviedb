package ch.bfh.ti.aimlessweeknight.moviedb.repository;

import ch.bfh.ti.aimlessweeknight.moviedb.domain.Actor;
import ch.bfh.ti.aimlessweeknight.moviedb.domain.Movie;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Christian on 18.11.2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/persistenceContext.xml")
public class ActorRepositoryIT {
    @Inject
    private ActorRepository actorRepository;

    @Test
    public void test(){
        // Create
        Actor newActor = new Actor();
        newActor.setName("Brad Pitt");
        actorRepository.save(newActor);

        // Read
        Actor readActor = actorRepository.findOne(newActor.getId());
        Assert.assertEquals(newActor.getName(), readActor.getName());

        // Update
        readActor.setName("Jodie Foster");
        readActor = actorRepository.save(readActor);
        Actor updatedActor = actorRepository.findOne(readActor.getId());
        Assert.assertEquals(readActor.getName(), updatedActor.getName());

        // Delete
        actorRepository.delete(updatedActor);
        Actor deletedActor = actorRepository.findOne(readActor.getId());
        Assert.assertNull(deletedActor);

    }
}
