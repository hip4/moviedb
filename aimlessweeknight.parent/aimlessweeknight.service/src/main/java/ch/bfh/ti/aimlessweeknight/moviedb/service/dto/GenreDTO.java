package ch.bfh.ti.aimlessweeknight.moviedb.service.dto;

import ch.bfh.ti.aimlessweeknight.moviedb.domain.Movie;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Christian on 11.11.2014.
 */
@Entity
public class GenreDTO {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    /*

    private Collection<MovieDTO> movies;

    public Collection<MovieDTO> getMovies() {
        return movies;
    }

    public void setMovies(Collection<MovieDTO> movies) {
        this.movies = movies;
    }
*/
}
