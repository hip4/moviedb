package ch.bfh.ti.aimlessweeknight.moviedb.service;

import ch.bfh.ti.aimlessweeknight.moviedb.service.dto.MovieDTO;
import ch.bfh.ti.aimlessweeknight.moviedb.service.dto.PossessionDTO;

import java.util.Collection;

/**
 * Created by Christian on 25.11.2014.
 */
public interface PossessionService {
    public PossessionDTO create(PossessionDTO possession);
    public PossessionDTO read(long id);
    public Collection<PossessionDTO> list();
    public PossessionDTO update(PossessionDTO possession);
    public void delete(PossessionDTO possession);
}
