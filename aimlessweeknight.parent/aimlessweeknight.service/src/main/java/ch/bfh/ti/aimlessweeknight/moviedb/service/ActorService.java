package ch.bfh.ti.aimlessweeknight.moviedb.service;

import ch.bfh.ti.aimlessweeknight.moviedb.service.dto.ActorDTO;

import java.util.Collection;

/**
 * Created by Christian on 25.11.2014.
 */
public interface ActorService {
    public ActorDTO create(ActorDTO actor);
    public ActorDTO read(long id);
    public Collection<ActorDTO> list();
    public ActorDTO update(ActorDTO actor);
    public void delete(ActorDTO actor);
}
