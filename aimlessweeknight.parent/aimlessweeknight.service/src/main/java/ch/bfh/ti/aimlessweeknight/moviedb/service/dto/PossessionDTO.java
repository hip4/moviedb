package ch.bfh.ti.aimlessweeknight.moviedb.service.dto;

import ch.bfh.ti.aimlessweeknight.moviedb.domain.Movie;
import ch.bfh.ti.aimlessweeknight.moviedb.domain.User;

import javax.persistence.*;

/**
 * Created by Christian on 11.11.2014.
 */

public class PossessionDTO {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String physicalLocation;

    public String getPhysicalLocation() {
        return physicalLocation;
    }

    public void setPhysicalLocation(String physicalLocation) {
        this.physicalLocation = physicalLocation;
    }

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /*
    private UserDTO user;

    public UserDTO getUser(){
        return user;
    }

    public void setUser(UserDTO user){
        this.user = user;
    }

    */

    private MovieDTO movie;

    public MovieDTO getMovie(){
        return movie;
    }

    public void setMovie(MovieDTO movie){
        this.movie = movie;
    }
}
