package ch.bfh.ti.aimlessweeknight.moviedb.service.impl;

import ch.bfh.ti.aimlessweeknight.moviedb.domain.Movie;
import ch.bfh.ti.aimlessweeknight.moviedb.repository.MovieRepository;
import ch.bfh.ti.aimlessweeknight.moviedb.service.MovieService;
import ch.bfh.ti.aimlessweeknight.moviedb.service.dto.MovieDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import javax.inject.Inject;
import javax.inject.Named;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Christian on 25.11.2014.
 */
@Named
public class DefaultMovieService implements MovieService {

    @Inject
    private MovieRepository movieRepository;

    private final ModelMapper mapper = new ModelMapper();

    public MovieDTO create(MovieDTO movieDTO){
        Movie movie = mapper.map(movieDTO,Movie.class);
        // set data added
        movie.setDateAdded(new Date());
        Movie persistedMovie = movieRepository.save(movie);
        return mapper.map(persistedMovie, MovieDTO.class);
    }

    public MovieDTO read(long id){
        Movie movie = movieRepository.findOne(id);
        if (movie == null) return null;
        return mapper.map(movie,MovieDTO.class);
    }

    public Collection<MovieDTO> list() {
        Iterable<Movie> movies = movieRepository.findAll();
        Type listType = new TypeToken<Collection<MovieDTO>>() {}.getType();
        return mapper.map(movies, listType);
    }

    @Override
    public MovieDTO update(MovieDTO movieDTO) {
        Movie movie = mapper.map(movieDTO, Movie.class);
        Movie updatedMovie = movieRepository.save(movie);
        return mapper.map(updatedMovie,MovieDTO.class);
    }

    @Override
    public void delete(MovieDTO movieDTO) {
        Movie movie = movieRepository.findOne(movieDTO.getId());
        movieRepository.delete(movie);
    }

}
