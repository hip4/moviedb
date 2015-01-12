package ch.bfh.ti.aimlessweeknight.moviedb.repository;

import ch.bfh.ti.aimlessweeknight.moviedb.domain.Genre;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Christian on 18.11.2014.
 */
public interface GenreRepository extends CrudRepository<Genre,Long>{

}
