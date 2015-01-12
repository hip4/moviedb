package ch.bfh.ti.aimlessweeknight.moviedb.repository;

import ch.bfh.ti.aimlessweeknight.moviedb.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Christian on 18.11.2014.
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
