package ch.bfh.ti.aimlessweeknight.moviedb.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by hip4 on 04.11.14.
 */
@Entity
public class Actor {

    private Long id;

    @GeneratedValue
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String name;

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String birthname;

    @Basic
    public String getBirthname() {
        return birthname;
    }

    public void setBirthname(String birthname) {
        this.birthname = birthname;
    }

    private String placeofbirth;

    @Basic
    public String getPlaceofbirth() {
        return placeofbirth;
    }

    public void setPlaceofbirth(String placeofbirth) {
        this.placeofbirth = placeofbirth;
    }

    private String nationality;

    @Basic
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    private String biographie;

    @Basic
    public String getBiographie() {
        return biographie;
    }

    public void setBiographie(String biographie) {
        this.biographie = biographie;
    }

    private Collection<Movie> movies;

    @ManyToMany(mappedBy = "actors", cascade = CascadeType.DETACH)
    public Collection<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Collection<Movie> movies) {
        this.movies = movies;
    }
}
