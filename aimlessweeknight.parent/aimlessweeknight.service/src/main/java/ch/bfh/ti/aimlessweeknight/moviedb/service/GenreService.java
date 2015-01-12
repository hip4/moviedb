package ch.bfh.ti.aimlessweeknight.moviedb.service;

import ch.bfh.ti.aimlessweeknight.moviedb.service.dto.GenreDTO;

import java.util.Collection;

/**
 * Created by Christian on 25.11.2014.
 */
public interface GenreService {
    public GenreDTO create(GenreDTO genre);
    public GenreDTO read(long id);
    public Collection<GenreDTO> list();
    public GenreDTO update(GenreDTO genre);
    public void delete(GenreDTO genre);
}
