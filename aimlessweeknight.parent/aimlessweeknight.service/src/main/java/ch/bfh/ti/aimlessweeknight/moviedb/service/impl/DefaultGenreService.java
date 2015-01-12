package ch.bfh.ti.aimlessweeknight.moviedb.service.impl;

import ch.bfh.ti.aimlessweeknight.moviedb.domain.Genre;
import ch.bfh.ti.aimlessweeknight.moviedb.repository.GenreRepository;
import ch.bfh.ti.aimlessweeknight.moviedb.service.GenreService;
import ch.bfh.ti.aimlessweeknight.moviedb.service.dto.GenreDTO;
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
public class DefaultGenreService implements GenreService {

    @Inject
    private GenreRepository genreRepository;

    private final ModelMapper mapper = new ModelMapper();

    public GenreDTO create(GenreDTO genreDTO){
        Genre genre = mapper.map(genreDTO,Genre.class);
        Genre persistedGenre = genreRepository.save(genre);
        return mapper.map(persistedGenre, GenreDTO.class);
    }

    public GenreDTO read(long id){
        Genre genre = genreRepository.findOne(id);
        if (genre == null) return null;
        return mapper.map(genre,GenreDTO.class);
    }

    public Collection<GenreDTO> list() {
        Iterable<Genre> genres = genreRepository.findAll();
        Type listType = new TypeToken<Collection<GenreDTO>>() {}.getType();
        return mapper.map(genres, listType);
    }

    @Override
    public GenreDTO update(GenreDTO genreDTO) {
        Genre genre = mapper.map(genreDTO, Genre.class);
        Genre updatedGenre = genreRepository.save(genre);
        return mapper.map(updatedGenre,GenreDTO.class);
    }

    @Override
    public void delete(GenreDTO genreDTO) {
        Genre genre = genreRepository.findOne(genreDTO.getId());
        genreRepository.delete(genre);
    }

}
