package ch.bfh.ti.aimlessweeknight.moviedb.service.impl;

import ch.bfh.ti.aimlessweeknight.moviedb.domain.Possession;
import ch.bfh.ti.aimlessweeknight.moviedb.repository.PossessionRepository;
import ch.bfh.ti.aimlessweeknight.moviedb.service.PossessionService;
import ch.bfh.ti.aimlessweeknight.moviedb.service.dto.PossessionDTO;
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
public class DefaultPossessionService implements PossessionService {

    @Inject
    private PossessionRepository actorRepository;

    private final ModelMapper mapper = new ModelMapper();

    public PossessionDTO create(PossessionDTO actorDTO){
        Possession actor = mapper.map(actorDTO,Possession.class);
        Possession persistedPossession = actorRepository.save(actor);
        return mapper.map(persistedPossession, PossessionDTO.class);
    }

    public PossessionDTO read(long id){
        Possession actor = actorRepository.findOne(id);
        if (actor == null) return null;
        return mapper.map(actor,PossessionDTO.class);
    }

    public Collection<PossessionDTO> list() {
        Iterable<Possession> actors = actorRepository.findAll();
        Type listType = new TypeToken<Collection<PossessionDTO>>() {}.getType();
        return mapper.map(actors, listType);
    }

    @Override
    public PossessionDTO update(PossessionDTO actorDTO) {
        Possession actor = mapper.map(actorDTO, Possession.class);
        Possession updatedPossession = actorRepository.save(actor);
        return mapper.map(updatedPossession,PossessionDTO.class);
    }

    @Override
    public void delete(PossessionDTO actorDTO) {
        Possession actor = actorRepository.findOne(actorDTO.getId());
        actorRepository.delete(actor);
    }

}
