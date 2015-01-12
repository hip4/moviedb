package ch.bfh.ti.aimlessweeknight.moviedb.repository;

import ch.bfh.ti.aimlessweeknight.moviedb.domain.Movie;
import ch.bfh.ti.aimlessweeknight.moviedb.domain.Possession;
import ch.bfh.ti.aimlessweeknight.moviedb.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

/**
 * Created by Christian on 18.11.2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/persistenceContext.xml")
public class PossessionRepositoryIT {
    @Inject
    private PossessionRepository PossessionRepository;
    @Inject
    private MovieRepository MovieRepository;
    @Inject
    private UserRepository UserRepository;

    @Test
    public void test(){
        // Create
        Possession newPossession = new Possession();
        Movie newMovie = new Movie();
        User newUser = new User();
        newPossession.setPhysicalLocation("Hindelbank");
        newPossession.setMovie(newMovie);
        newPossession.setUser(newUser);
        newPossession.setUrl("http://example.org/movie1");
        UserRepository.save(newUser);
        MovieRepository.save(newMovie);
        PossessionRepository.save(newPossession);

        // Read
        Possession readPossession = PossessionRepository.findOne(newPossession.getId());
        Assert.assertEquals(newPossession.getPhysicalLocation(), readPossession.getPhysicalLocation());
        Assert.assertEquals(newPossession.getUrl(), readPossession.getUrl());
        Assert.assertEquals(newPossession.getUser().getId(), readPossession.getUser().getId());
        Assert.assertEquals(newPossession.getMovie().getId(), readPossession.getMovie().getId());


        // Update
        readPossession.setPhysicalLocation("Biel");
        readPossession.setUrl("http://example.org/movie2");
        Movie newMovie2 = new Movie();
        readPossession.setMovie(newMovie2);
        User newUser2 = new User();
        readPossession.setUser(newUser2);
        readPossession = PossessionRepository.save(readPossession);
        Possession updatedPossession = PossessionRepository.findOne(readPossession.getId());
        Assert.assertEquals(readPossession.getPhysicalLocation(), updatedPossession.getPhysicalLocation());
        Assert.assertEquals(readPossession.getUrl(), updatedPossession.getUrl());
        Assert.assertEquals(readPossession.getUser().getId(), updatedPossession.getUser().getId());
        Assert.assertEquals(readPossession.getMovie().getId(), updatedPossession.getMovie().getId());

        // Delete
        PossessionRepository.delete(updatedPossession);
        Possession deletedPossession = PossessionRepository.findOne(readPossession.getId());
        Assert.assertNull(deletedPossession);

    }
}