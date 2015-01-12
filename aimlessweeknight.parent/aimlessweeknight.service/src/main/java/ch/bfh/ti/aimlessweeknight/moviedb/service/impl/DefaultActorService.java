package ch.bfh.ti.aimlessweeknight.moviedb.service.impl;

import ch.bfh.ti.aimlessweeknight.moviedb.repository.ActorRepository;
import ch.bfh.ti.aimlessweeknight.moviedb.domain.Actor;
import ch.bfh.ti.aimlessweeknight.moviedb.service.ActorService;
import ch.bfh.ti.aimlessweeknight.moviedb.service.dto.ActorDTO;
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
public class DefaultActorService implements ActorService {

    @Inject
    private ActorRepository actorRepository;

    private final ModelMapper mapper = new ModelMapper();

    public ActorDTO create(ActorDTO actorDTO){
        Actor actor = mapper.map(actorDTO,Actor.class);
        Actor persistedActor = actorRepository.save(actor);
        return mapper.map(persistedActor, ActorDTO.class);
    }

    public ActorDTO read(long id){
        Actor actor = actorRepository.findOne(id);
        if (actor == null) return null;
        return mapper.map(actor,ActorDTO.class);
    }

    public Collection<ActorDTO> list() {
        Iterable<Actor> actors = actorRepository.findAll();
        Type listType = new TypeToken<Collection<ActorDTO>>() {}.getType();
        return mapper.map(actors, listType);
    }

    @Override
    public ActorDTO update(ActorDTO actorDTO) {
        Actor actor = mapper.map(actorDTO, Actor.class);
        Actor updatedActor = actorRepository.save(actor);
        return mapper.map(updatedActor,ActorDTO.class);
    }

    @Override
    public void delete(ActorDTO actorDTO) {
        Actor actor = actorRepository.findOne(actorDTO.getId());
        actorRepository.delete(actor);
    }

}
