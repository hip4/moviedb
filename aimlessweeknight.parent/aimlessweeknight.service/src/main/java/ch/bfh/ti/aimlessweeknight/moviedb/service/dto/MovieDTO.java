package ch.bfh.ti.aimlessweeknight.moviedb.service.dto;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

/**
 * Created by hip4 on 04.11.14.
 */
@Entity
public class MovieDTO {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String originalTitle;

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    private String plotOutline;

    public String getPlotOutline() {
        return plotOutline;
    }

    public void setPlotOutline(String plotOutline) {
        this.plotOutline = plotOutline;
    }

    private Date releaseDate;

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    private String director;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    private String trailerUrl;

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    private int playCount;

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    private long totalTimeInSeconds;

    public long getTotalTimeInSeconds() {
        return totalTimeInSeconds;
    }

    public void setTotalTimeInSeconds(long totalTimeInSeconds) {
        this.totalTimeInSeconds = totalTimeInSeconds;
    }

    private Date dateAdded;

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    private String thumbnailUrl;

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    private Collection<ActorDTO> actors;

    public Collection<ActorDTO> getActors() {
        return actors;
    }

    public void setActors(Collection<ActorDTO> actors) {
        this.actors = actors;
    }

    private Collection<GenreDTO> genres;

    public Collection<GenreDTO> getGenres() {
        return genres;
    }

    public void setGenres(Collection<GenreDTO> genres) {
        this.genres = genres;
    }

    private Collection<StudioDTO> studios;

    public Collection<StudioDTO> getStudios() {
        return studios;
    }

    public void setStudios(Collection<StudioDTO> studios) {
        this.studios = studios;
    }

    /*
    private Collection<PossessionDTO> possessions;

    public Collection<PossessionDTO> getPossessions() {
        return possessions;
    }

    public void setPossessions(Collection<PossessionDTO> possessions){
        this.possessions = possessions;
    }
    */
}
