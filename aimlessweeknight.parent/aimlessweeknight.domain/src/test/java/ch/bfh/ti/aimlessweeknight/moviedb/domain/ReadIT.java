/**
 * 
 */
package ch.bfh.ti.aimlessweeknight.moviedb.domain;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author rovi
 * 
 */
public class ReadIT {


	@Test
	public void testActors() {

		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.ti.aimlessweeknight.moviedb.domain").createEntityManager();

        Query qmovies = em.createQuery("select m from Movie m");
        List<Movie> foundMovies = qmovies.getResultList();
        Assert.assertEquals(2, foundMovies.size());

        Movie firstMovie = foundMovies.get(0);
        Movie secondMovie = foundMovies.get(1);

        Assert.assertEquals("Der Herr der Ringe - Die Gefährten", firstMovie.getOriginalTitle());
        Assert.assertEquals("Der Herr der Ringe - Die zwei Türme", secondMovie.getOriginalTitle());

        Query q = em.createQuery("select a from Actor a");

        List<Actor> foundActors = q.getResultList();
        Actor firstActor = foundActors.get(0);
        Assert.assertEquals("Orlando Bloom", firstActor.getName());
        Assert.assertEquals(2, firstActor.getMovies().size());
        Assert.assertTrue(firstActor.getMovies().contains(firstMovie));
        Assert.assertTrue(firstActor.getMovies().contains(secondMovie));

        Assert.assertEquals(2, firstActor.getMovies().size());

        Actor secondActor = foundActors.get(1);
        Assert.assertEquals("Elijah Wood", secondActor.getName());
        Assert.assertEquals(2, secondActor.getMovies().size());
        Assert.assertTrue(secondActor.getMovies().contains(firstMovie));
        Assert.assertTrue(secondActor.getMovies().contains(secondMovie));

        Actor thirdActor = foundActors.get(2);
        Assert.assertEquals("Sean Bean", thirdActor.getName());
        Assert.assertEquals(1, thirdActor.getMovies().size());
        Assert.assertTrue(thirdActor.getMovies().contains(firstMovie));
	}

    @Test
    public void testMovies() {

        EntityManager em = Persistence.createEntityManagerFactory(
                "ch.bfh.ti.aimlessweeknight.moviedb.domain").createEntityManager();

        // get actors
        Query q = em.createQuery("select a from Actor a");

        List<Actor> foundActors = q.getResultList();
        Actor firstActor = foundActors.get(0);
        Actor secondActor = foundActors.get(1);
        Actor thirdActor = foundActors.get(2);

        Assert.assertEquals("Orlando Bloom", firstActor.getName());
        Assert.assertEquals("Elijah Wood", secondActor.getName());
        Assert.assertEquals("Sean Bean", thirdActor.getName());

        // get movies
        Query qmovies = em.createQuery("select m from Movie m");
        List<Movie> foundMovies = qmovies.getResultList();
        Assert.assertEquals(2, foundMovies.size());

        Movie firstMovie = foundMovies.get(0);
        Movie secondMovie = foundMovies.get(1);

        Assert.assertEquals("Der Herr der Ringe - Die Gefährten", firstMovie.getOriginalTitle());
        Assert.assertEquals("Der Herr der Ringe - Die zwei Türme", secondMovie.getOriginalTitle());

        // first movie
        Assert.assertEquals(3, firstMovie.getActors().size());
        Assert.assertTrue(firstMovie.getActors().contains(firstActor));
        Assert.assertTrue(firstMovie.getActors().contains(secondActor));
        Assert.assertTrue(firstMovie.getActors().contains(thirdActor));

        Assert.assertEquals(2, secondMovie.getActors().size());
        Assert.assertTrue(secondMovie.getActors().contains(firstActor));
        Assert.assertTrue(secondMovie.getActors().contains(secondActor));
        Assert.assertFalse(secondMovie.getActors().contains(thirdActor));

    }

}
