package ch.bfh.ti.aimlessweeknight.moviedb.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

/**
 * Created by hip4 on 04.11.14.
 */
@Entity
public class Movie {
    private Long id;

    @GeneratedValue
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String originalTitle;

    @Basic
    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    private String plotOutline;

    @Basic
    public String getPlotOutline() {
        return plotOutline;
    }

    public void setPlotOutline(String plotOutline) {
        this.plotOutline = plotOutline;
    }

    private Date releaseDate;

    @Basic
    @Temporal(TemporalType.DATE)
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    private String director;

    @Basic
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    private String trailerUrl;

    @Basic
    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    private int playCount;

    @Basic
    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    private long totalTimeInSeconds;

    @Basic
    public long getTotalTimeInSeconds() {
        return totalTimeInSeconds;
    }

    public void setTotalTimeInSeconds(long totalTimeInSeconds) {
        this.totalTimeInSeconds = totalTimeInSeconds;
    }

    private Date dateAdded;

    @Basic
    @Temporal(TemporalType.DATE)
    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    private String thumbnailUrl;

    @Basic
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    private Collection<Actor> actors;

    @ManyToMany
    public Collection<Actor> getActors() {
        return actors;
    }

    public void setActors(Collection<Actor> actors) {
        this.actors = actors;
    }


    private Collection<Genre> genres;

    @ManyToMany
    public Collection<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Collection<Genre> genres) {
        this.genres = genres;
    }


    private Collection<Studio> studios;

    @ManyToMany
    public Collection<Studio> getStudios() {
        return studios;
    }

    public void setStudios(Collection<Studio> studios) {
        this.studios = studios;
    }

    private Collection<Possession> possessions;

    @OneToMany(mappedBy = "movie")
    public Collection<Possession> getPossessions() {
        return possessions;
    }

    public void setPossessions(Collection<Possession> possessions){
        this.possessions = possessions;
    }
}
