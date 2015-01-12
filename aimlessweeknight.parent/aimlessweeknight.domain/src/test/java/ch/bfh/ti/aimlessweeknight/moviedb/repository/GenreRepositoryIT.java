package ch.bfh.ti.aimlessweeknight.moviedb.repository;

import ch.bfh.ti.aimlessweeknight.moviedb.domain.Genre;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

/**
 * Created by Christian on 18.11.2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/persistenceContext.xml")
public class GenreRepositoryIT {
    @Inject
    private GenreRepository GenreRepository;

    @Test
    public void test(){
        // Create
        Genre newGenre = new Genre();
        newGenre.setLabel("Drama");
        GenreRepository.save(newGenre);

        // Read
        Genre readGenre = GenreRepository.findOne(newGenre.getId());
        Assert.assertEquals(newGenre.getLabel(), readGenre.getLabel());

        // Update
        readGenre.setLabel("Thriller");
        readGenre = GenreRepository.save(readGenre);
        Genre updatedGenre = GenreRepository.findOne(readGenre.getId());
        Assert.assertEquals(readGenre.getLabel(), updatedGenre.getLabel());

        // Delete
        GenreRepository.delete(updatedGenre);
        Genre deletedGenre = GenreRepository.findOne(readGenre.getId());
        Assert.assertNull(deletedGenre);

    }
}