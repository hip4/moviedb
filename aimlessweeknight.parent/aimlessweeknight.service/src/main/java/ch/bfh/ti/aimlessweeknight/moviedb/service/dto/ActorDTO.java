package ch.bfh.ti.aimlessweeknight.moviedb.service.dto;

import ch.bfh.ti.aimlessweeknight.moviedb.domain.Movie;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by hip4 on 04.11.14.
 */
@Entity
public class ActorDTO {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String birthname;

    public String getBirthname() {
        return birthname;
    }

    public void setBirthname(String birthname) {
        this.birthname = birthname;
    }

    private String placeofbirth;


    public String getPlaceofbirth() {
        return placeofbirth;
    }

    public void setPlaceofbirth(String placeofbirth) {
        this.placeofbirth = placeofbirth;
    }

    private String nationality;


    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    private String biographie;

    public String getBiographie() {
        return biographie;
    }

    public void setBiographie(String biographie) {
        this.biographie = biographie;
    }

    /*private Collection<MovieDTO> movies;

    //public Collection<MovieDTO> getMovies() {
        return movies;
    }

    //public void setMovies(Collection<MovieDTO> movies) {
        this.movies = movies;
    }
    */
}
