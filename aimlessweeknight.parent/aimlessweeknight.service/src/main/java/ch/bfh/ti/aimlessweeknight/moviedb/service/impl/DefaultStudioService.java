package ch.bfh.ti.aimlessweeknight.moviedb.service.impl;

import ch.bfh.ti.aimlessweeknight.moviedb.domain.Studio;
import ch.bfh.ti.aimlessweeknight.moviedb.repository.StudioRepository;
import ch.bfh.ti.aimlessweeknight.moviedb.service.StudioService;
import ch.bfh.ti.aimlessweeknight.moviedb.service.dto.StudioDTO;
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
public class DefaultStudioService implements StudioService {

    @Inject
    private StudioRepository studioRepository;

    private final ModelMapper mapper = new ModelMapper();

    public StudioDTO create(StudioDTO studioDTO){
        Studio studio = mapper.map(studioDTO,Studio.class);
        Studio persistedStudio = studioRepository.save(studio);
        return mapper.map(persistedStudio, StudioDTO.class);
    }

    public StudioDTO read(long id){
        Studio studio = studioRepository.findOne(id);
        if (studio == null) return null;
        return mapper.map(studio,StudioDTO.class);
    }

    public Collection<StudioDTO> list() {
        Iterable<Studio> studios = studioRepository.findAll();
        Type listType = new TypeToken<Collection<StudioDTO>>() {}.getType();
        return mapper.map(studios, listType);
    }

    @Override
    public StudioDTO update(StudioDTO studioDTO) {
        Studio studio = mapper.map(studioDTO, Studio.class);
        Studio updatedStudio = studioRepository.save(studio);
        return mapper.map(updatedStudio,StudioDTO.class);
    }

    @Override
    public void delete(StudioDTO studioDTO) {
        Studio studio = studioRepository.findOne(studioDTO.getId());
        studioRepository.delete(studio);
    }

}
