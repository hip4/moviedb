package ch.bfh.ti.aimlessweeknight.moviedb.service;

import ch.bfh.ti.aimlessweeknight.moviedb.service.dto.MovieDTO;

import java.util.Collection;

/**
 * Created by Christian on 25.11.2014.
 */
public interface MovieService {
    public MovieDTO create(MovieDTO movie);
    public MovieDTO read(long id);
    public Collection<MovieDTO> list();
    public MovieDTO update(MovieDTO movie);
    public void delete(MovieDTO movie);
}
