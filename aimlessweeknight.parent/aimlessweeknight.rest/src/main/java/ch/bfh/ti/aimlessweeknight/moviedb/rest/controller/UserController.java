package ch.bfh.ti.aimlessweeknight.moviedb.rest.controller;

import ch.bfh.ti.aimlessweeknight.moviedb.service.UserService;
import ch.bfh.ti.aimlessweeknight.moviedb.service.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Collection;


@Controller
@RequestMapping("/users")
public class UserController {

	@Inject
	private UserService userService;

	/**
	 * Create
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public UserDTO createUser(@RequestBody UserDTO user) {
		UserDTO createdUser = userService.create(user);
		System.out.println("User created with id = " + createdUser.getId());
		return createdUser;
	}

	/**
	 * ReadAll
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<UserDTO> getUsers() {
		System.out.println("Collection of User requested");
		return userService.list();
	}

	/**
	 * Read
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public UserDTO getUser(@PathVariable long id) {
		System.out.println("User requested with id = " + id);
		return userService.read(id);
	}

	/**
	 * Update
	 */
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public UserDTO updateUser(@RequestBody UserDTO user) {
		UserDTO updatedUser = userService.update(user);
		System.out.println("User updated with id = " + updatedUser.getId());
		return updatedUser;
	}

	/**
	 * Delete
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteUser(@PathVariable long id) {
		UserDTO user = userService.read(id);
		userService.delete(user);
		System.out.println("Delete User with id = " + id);
	}
}
