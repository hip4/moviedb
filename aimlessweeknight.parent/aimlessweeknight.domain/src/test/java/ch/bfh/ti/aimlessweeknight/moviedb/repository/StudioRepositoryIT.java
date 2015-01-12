package ch.bfh.ti.aimlessweeknight.moviedb.repository;

import ch.bfh.ti.aimlessweeknight.moviedb.domain.Movie;
import ch.bfh.ti.aimlessweeknight.moviedb.domain.Possession;
import ch.bfh.ti.aimlessweeknight.moviedb.domain.Studio;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Christian on 18.11.2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/persistenceContext.xml")
public class StudioRepositoryIT {
    @Inject
    private StudioRepository StudioRepository;

    @Test
    public void test(){
        // Create
        Studio newStudio = new Studio();
        newStudio.setLabel("Pixar");
        newStudio.setLogoURL("http://example.org/logo1");
        Collection<Movie> movies = new ArrayList<Movie>();
        newStudio.setMovies(movies);
        StudioRepository.save(newStudio);

        // Read
        Studio readStudio = StudioRepository.findOne(newStudio.getId());
        Assert.assertEquals(newStudio.getLabel(), readStudio.getLabel());
        Assert.assertEquals(newStudio.getLogoURL(), readStudio.getLogoURL());
        Assert.assertEquals(newStudio.getMovies(), readStudio.getMovies());


        // Update
        readStudio.setLabel("Dreamworks");
        readStudio.setLogoURL("http://example.org/logo2");
        Movie newMovie = new Movie();
        readStudio.getMovies().add(newMovie);
        readStudio = StudioRepository.save(readStudio);
        Studio updatedStudio = StudioRepository.findOne(readStudio.getId());
        Assert.assertEquals(readStudio.getLabel(), updatedStudio.getLabel());
        Assert.assertEquals(readStudio.getLogoURL(), updatedStudio.getLogoURL());
        Assert.assertEquals(readStudio.getMovies().size(), updatedStudio.getMovies().size());
        for(Movie movie : readStudio.getMovies()) {
            boolean same = false;
            for(Movie m : updatedStudio.getMovies()) {
                if (m.getId() == movie.getId()){
                    same = true;
                    break;
                }
            }
            Assert.assertTrue(same);
        }

        // Delete
        StudioRepository.delete(updatedStudio);
        Studio deletedStudio = StudioRepository.findOne(readStudio.getId());
        Assert.assertNull(deletedStudio);

    }
}