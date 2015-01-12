package ch.bfh.ti.aimlessweeknight.moviedb.repository;

import org.springframework.data.repository.CrudRepository;
import ch.bfh.ti.aimlessweeknight.moviedb.domain.Actor;

/**
 * Created by Christian on 18.11.2014.
 */
public interface ActorRepository extends CrudRepository<Actor,Long> {

}
