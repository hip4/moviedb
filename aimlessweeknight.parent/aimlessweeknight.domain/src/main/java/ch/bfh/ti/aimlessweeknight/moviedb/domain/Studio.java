package ch.bfh.ti.aimlessweeknight.moviedb.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Christian on 11.11.2014.
 */
@Entity
public class Studio {
    private Long id;

    @GeneratedValue
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String label;

    @Basic
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    private String logoURL;

    @Basic
    public String getLogoURL() {
        return logoURL;
    }

    public void setLogoURL(String logoURL) {
        this.logoURL = logoURL;
    }


    private Collection<Movie> movies;

    @ManyToMany
    public Collection<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Collection<Movie> movies) {
        this.movies = movies;
    }
}
