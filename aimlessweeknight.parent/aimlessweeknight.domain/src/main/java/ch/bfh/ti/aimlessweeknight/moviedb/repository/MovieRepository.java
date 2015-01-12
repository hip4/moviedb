package ch.bfh.ti.aimlessweeknight.moviedb.repository;

import org.springframework.data.repository.CrudRepository;
import ch.bfh.ti.aimlessweeknight.moviedb.domain.Movie;

/**
 * Created by Christian on 18.11.2014.
 */
public interface MovieRepository extends CrudRepository<Movie, Long> {
}
