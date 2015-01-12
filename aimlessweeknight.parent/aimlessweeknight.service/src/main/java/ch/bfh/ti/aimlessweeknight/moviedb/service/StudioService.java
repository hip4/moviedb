package ch.bfh.ti.aimlessweeknight.moviedb.service;

import ch.bfh.ti.aimlessweeknight.moviedb.service.dto.MovieDTO;
import ch.bfh.ti.aimlessweeknight.moviedb.service.dto.StudioDTO;

import java.util.Collection;

/**
 * Created by Christian on 25.11.2014.
 */
public interface StudioService {
    public StudioDTO create(StudioDTO studio);
    public StudioDTO read(long id);
    public Collection<StudioDTO> list();
    public StudioDTO update(StudioDTO studio);
    public void delete(StudioDTO studio);
}
