package ch.bfh.ti.aimlessweeknight.moviedb.service.impl;

import ch.bfh.ti.aimlessweeknight.moviedb.domain.User;
import ch.bfh.ti.aimlessweeknight.moviedb.repository.UserRepository;
import ch.bfh.ti.aimlessweeknight.moviedb.service.UserService;
import ch.bfh.ti.aimlessweeknight.moviedb.service.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import javax.inject.Inject;
import javax.inject.Named;
import java.lang.reflect.Type;
import java.util.Collection;

/**
 * Created by Christian on 25.11.2014.
 */
@Named
public class DefaultUserService implements UserService {

    @Inject
    private UserRepository userRepository;

    private final ModelMapper mapper = new ModelMapper();

    public UserDTO create(UserDTO userDTO){
        User user = mapper.map(userDTO,User.class);
        User persistedUser = userRepository.save(user);
        return mapper.map(persistedUser, UserDTO.class);
    }

    public UserDTO read(long id){
        User user = userRepository.findOne(id);
        if (user == null) return null;
        return mapper.map(user,UserDTO.class);
    }

    public Collection<UserDTO> list() {
        Iterable<User> users = userRepository.findAll();
        Type listType = new TypeToken<Collection<UserDTO>>() {}.getType();
        return mapper.map(users, listType);
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        User user = mapper.map(userDTO, User.class);
        User updatedUser = userRepository.save(user);
        return mapper.map(updatedUser,UserDTO.class);
    }

    @Override
    public void delete(UserDTO userDTO) {
        User user = userRepository.findOne(userDTO.getId());
        userRepository.delete(user);
    }

}
