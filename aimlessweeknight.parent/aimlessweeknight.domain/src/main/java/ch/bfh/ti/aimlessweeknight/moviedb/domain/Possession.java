package ch.bfh.ti.aimlessweeknight.moviedb.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Christian on 11.11.2014.
 */
@Entity
public class Possession {

    @GeneratedValue
    @Id
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String physicalLocation;

    @Basic
    public String getPhysicalLocation() {
        return physicalLocation;
    }

    public void setPhysicalLocation(String physicalLocation) {
        this.physicalLocation = physicalLocation;
    }

    private String url;

    @Basic
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @ManyToOne
    private User user;

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    @ManyToOne
    private Movie movie;

    public Movie getMovie(){
        return movie;
    }

    public void setMovie(Movie movie){
        this.movie = movie;
    }
}
