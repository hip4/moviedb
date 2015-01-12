package ch.bfh.ti.aimlessweeknight.moviedb.repository;

import ch.bfh.ti.aimlessweeknight.moviedb.domain.Actor;
import ch.bfh.ti.aimlessweeknight.moviedb.domain.Genre;
import ch.bfh.ti.aimlessweeknight.moviedb.domain.Movie;
import ch.bfh.ti.aimlessweeknight.moviedb.domain.Possession;
import ch.bfh.ti.aimlessweeknight.moviedb.testutils.AssertDate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Christian on 18.11.2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/persistenceContext.xml")
public class MovieRepositoryIT {
    @Inject
    private MovieRepository MovieRepository;

    @Test
    public void test(){
        // Create
        Movie newMovie = new Movie();
        Collection<Actor> actors = new ArrayList<Actor>();
        Collection<Genre> genres = new ArrayList<Genre>();
        Collection<Possession> possessions = new ArrayList<Possession>();
        newMovie.setOriginalTitle("A Bug's Life");
        newMovie.setDateAdded(new Date());
        newMovie.setActors(actors);
        newMovie.setPossessions(possessions);
        newMovie.setGenres(genres);
        newMovie.setDirector("Tom Hanks");
        newMovie.setPlayCount(0);
        newMovie.setPlotOutline("Plot");
        Date releaseDate = new Date();
        releaseDate.setYear(2001);
        newMovie.setReleaseDate(releaseDate);
        newMovie.setThumbnailUrl("http://example.org/thumb01");
        newMovie.setTotalTimeInSeconds(7200);
        newMovie.setTrailerUrl("http://example.org/trailer01");
        MovieRepository.save(newMovie);

        // Read
        Movie readMovie = MovieRepository.findOne(newMovie.getId());
        Assert.assertEquals(newMovie.getOriginalTitle(), readMovie.getOriginalTitle());
        AssertDate.assertEquals(newMovie.getDateAdded(), readMovie.getDateAdded());
        Assert.assertEquals(newMovie.getActors(), readMovie.getActors());
        Assert.assertEquals(newMovie.getPossessions(), readMovie.getPossessions());
        Assert.assertEquals(newMovie.getGenres(), readMovie.getGenres());
        Assert.assertEquals(newMovie.getDirector(), readMovie.getDirector());
        Assert.assertEquals(newMovie.getPlayCount(), readMovie.getPlayCount());
        Assert.assertEquals(newMovie.getPlotOutline(), readMovie.getPlotOutline());
        Assert.assertEquals(newMovie.getReleaseDate(), readMovie.getReleaseDate());
        Assert.assertEquals(newMovie.getThumbnailUrl(), readMovie.getThumbnailUrl());
        Assert.assertEquals(newMovie.getTotalTimeInSeconds(), readMovie.getTotalTimeInSeconds());
        Assert.assertEquals(newMovie.getTrailerUrl(), readMovie.getTrailerUrl());

        // Update
        readMovie.setOriginalTitle("Antz");
        readMovie.setDateAdded(new Date());
        readMovie.setActors(new ArrayList<Actor>());
        readMovie.setPossessions(new ArrayList<Possession>());
        readMovie.setGenres(new ArrayList<Genre>());
        readMovie.setDirector("Tom Banks");
        readMovie.setPlayCount(1);
        readMovie.setPlotOutline("Plot Extended");
        Date releaseDateRead = new Date();
        releaseDateRead.setYear(2002);
        readMovie.setReleaseDate(releaseDateRead);
        readMovie.setThumbnailUrl("http://example.org/thumb02");
        readMovie.setTotalTimeInSeconds(7205);
        readMovie.setTrailerUrl("http://example.org/trailer02");
        readMovie = MovieRepository.save(readMovie);
        Movie updatedMovie = MovieRepository.findOne(readMovie.getId());

        Assert.assertEquals(readMovie.getOriginalTitle(), updatedMovie.getOriginalTitle());
        AssertDate.assertEquals(readMovie.getDateAdded(), updatedMovie.getDateAdded());
        Assert.assertEquals(readMovie.getActors(), updatedMovie.getActors());
        Assert.assertEquals(readMovie.getPossessions(), updatedMovie.getPossessions());
        Assert.assertEquals(readMovie.getGenres(), updatedMovie.getGenres());
        Assert.assertEquals(readMovie.getDirector(), updatedMovie.getDirector());
        Assert.assertEquals(readMovie.getPlayCount(), updatedMovie.getPlayCount());
        Assert.assertEquals(readMovie.getPlotOutline(), updatedMovie.getPlotOutline());
        Assert.assertEquals(readMovie.getReleaseDate(), updatedMovie.getReleaseDate());
        Assert.assertEquals(readMovie.getThumbnailUrl(), updatedMovie.getThumbnailUrl());
        Assert.assertEquals(readMovie.getTotalTimeInSeconds(), updatedMovie.getTotalTimeInSeconds());
        Assert.assertEquals(readMovie.getTrailerUrl(), updatedMovie.getTrailerUrl());

        // Delete
        MovieRepository.delete(updatedMovie);
        Movie deletedMovie = MovieRepository.findOne(readMovie.getId());
        Assert.assertNull(deletedMovie);

    }
}