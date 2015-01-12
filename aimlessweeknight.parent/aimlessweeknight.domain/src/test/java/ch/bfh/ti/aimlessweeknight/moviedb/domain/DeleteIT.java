/**
 * 
 */
package ch.bfh.ti.aimlessweeknight.moviedb.domain;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import junit.framework.Assert;
import org.junit.Test;

/**
 * @author rovi
 * 
 */
public class DeleteIT {

	@Test
	public void test() {

		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.ti.aimlessweeknight.moviedb.domain").createEntityManager();

		Query q = em.createQuery("select a from Actor a");
		List<Actor> foundActors = q.getResultList();
        Assert.assertEquals(3, foundActors.size());
		Actor firstActor = foundActors.get(0);
        Assert.assertEquals("Orlando Bloom", firstActor.getName());

		// Write access needs a transaction
		em.getTransaction().begin();
		em.remove(firstActor);
		em.getTransaction().commit();

        Query qAfterDelete = em.createQuery("select a from Actor a");
        List<Actor> foundActorsAfterDelete = q.getResultList();
        Assert.assertEquals(2, foundActorsAfterDelete.size());
        Actor firstActorAfterDelete = foundActorsAfterDelete.get(0);
        Assert.assertNotSame("Orlando Bloom", firstActorAfterDelete.getName());

        Query qmovies = em.createQuery("select m from Movie m");
        List<Movie> foundMovies = qmovies.getResultList();
        Assert.assertEquals(2, foundMovies.size());
        Movie firstMovie = foundMovies.get(0);
        Assert.assertEquals(2, firstMovie.getActors().size());
        Assert.assertFalse(firstMovie.getActors().contains(firstActor));
	}

}
