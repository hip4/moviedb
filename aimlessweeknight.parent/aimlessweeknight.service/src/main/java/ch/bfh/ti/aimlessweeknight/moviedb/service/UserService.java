package ch.bfh.ti.aimlessweeknight.moviedb.service;

import ch.bfh.ti.aimlessweeknight.moviedb.service.dto.UserDTO;

import java.util.Collection;

/**
 * Created by Christian on 25.11.2014.
 */
public interface UserService {
    public UserDTO create(UserDTO user);
    public UserDTO read(long id);
    public Collection<UserDTO> list();
    public UserDTO update(UserDTO user);
    public void delete(UserDTO user);
}
