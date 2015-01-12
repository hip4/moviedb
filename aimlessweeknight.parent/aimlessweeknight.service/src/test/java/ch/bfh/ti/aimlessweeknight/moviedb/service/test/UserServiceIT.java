package ch.bfh.ti.aimlessweeknight.moviedb.service.test;

import ch.bfh.ti.aimlessweeknight.moviedb.service.MovieService;
import ch.bfh.ti.aimlessweeknight.moviedb.service.UserService;
import ch.bfh.ti.aimlessweeknight.moviedb.service.dto.MovieDTO;
import ch.bfh.ti.aimlessweeknight.moviedb.service.dto.UserDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/serviceContext.xml")
public class UserServiceIT {

	@Inject
	private UserService userService;

	@Test
	public void test() {

		// Create
		UserDTO newUser = new UserDTO();
		newUser.setUsername("user0001");
		newUser = userService.create(newUser);

		// Read
		UserDTO readUser = userService.read(newUser.getId());
		Assert.assertTrue(newUser.getUsername().equals(readUser.getUsername()));

		// Update
		readUser.setUsername("user0002");
		readUser = userService.update(readUser);
		UserDTO updatedUser = userService.read(readUser.getId());
		Assert.assertTrue(readUser.getUsername().equals(updatedUser.getUsername()));

		// Delete
		userService.delete(updatedUser);
		UserDTO deletedUser = userService.read(readUser.getId());
		Assert.assertNull(deletedUser);
	}

}
