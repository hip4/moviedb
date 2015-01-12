package ch.bfh.ti.aimlessweeknight.moviedb.repository;

import ch.bfh.ti.aimlessweeknight.moviedb.domain.Possession;
import ch.bfh.ti.aimlessweeknight.moviedb.domain.Studio;
import ch.bfh.ti.aimlessweeknight.moviedb.domain.User;
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
public class UserRepositoryIT {
    @Inject
    private UserRepository UserRepository;

    @Test
    public void test(){
        // Create
        User newUser = new User();
        newUser.setUsername("User0001");
        newUser.setEmail("user0001@example.org");
        Collection<Possession> newPossessions = new ArrayList<Possession>();
        newUser.setPossessions(newPossessions);
        UserRepository.save(newUser);

        // Read
        User readUser = UserRepository.findOne(newUser.getId());
        Assert.assertEquals(newUser.getUsername(), readUser.getUsername());
        Assert.assertEquals(newUser.getEmail(), readUser.getEmail());
        Assert.assertEquals(newUser.getPossessions(), readUser.getPossessions());

        // Update
        readUser.setUsername("User0002");
        readUser.setEmail("user0002@example.org");
        Collection<Possession> possessions2 = new ArrayList<Possession>();
        readUser.setPossessions(possessions2);
        readUser = UserRepository.save(readUser);
        User updatedUser = UserRepository.findOne(readUser.getId());
        Assert.assertEquals(readUser.getUsername(), updatedUser.getUsername());
        Assert.assertEquals(readUser.getEmail(), updatedUser.getEmail());
        Assert.assertEquals(readUser.getPossessions(), updatedUser.getPossessions());

        // Delete
        UserRepository.delete(updatedUser);
        User deletedUser = UserRepository.findOne(readUser.getId());
        Assert.assertNull(deletedUser);

    }
}