/**
 *
 */
package ch.bfh.ti.aimlessweeknight.moviedb.domain;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author hip4
 */
public class CreateIT {

    @Test
    public void test() {
        Actor actor1 = new Actor();
        actor1.setName("Orlando Bloom");

        Actor actor2 = new Actor();
        actor2.setName("Elijah Wood");

        Actor actor3 = new Actor();
        actor3.setName("Sean Bean");

        Movie movie1 = new Movie();
        movie1.setOriginalTitle("Der Herr der Ringe - Die Gefährten");
        movie1.setDateAdded(new Date());

        Movie movie2 = new Movie();
        movie2.setOriginalTitle("Der Herr der Ringe - Die zwei Türme");
        movie2.setDateAdded(new Date());

        ArrayList<Actor> actors1 = new ArrayList<Actor>();
        actors1.add(actor1);
        actors1.add(actor2);
        actors1.add(actor3);

        ArrayList<Actor> actors2 = new ArrayList<Actor>();
        actors2.add(actor1);
        actors2.add(actor2);

        ArrayList<Movie> moviesActor1 = new ArrayList<Movie>();
        moviesActor1.add(movie1);
        moviesActor1.add(movie2);

        ArrayList<Movie> moviesActor2 = new ArrayList<Movie>();
        moviesActor2.add(movie1);
        moviesActor2.add(movie2);

        ArrayList<Movie> moviesActor3 = new ArrayList<Movie>();
        moviesActor3.add(movie1);

        movie1.setActors(actors1);
        movie2.setActors(actors2);

        actor1.setMovies(moviesActor1);
        actor2.setMovies(moviesActor2);
        actor3.setMovies(moviesActor3);

        EntityManager em = Persistence.createEntityManagerFactory(
                "ch.bfh.ti.aimlessweeknight.moviedb.domain").createEntityManager();

        em.getTransaction().begin();
        em.persist(movie1);
        em.persist(movie2);
        em.persist(actor1);
        em.persist(actor2);
        em.persist(actor3);
        em.getTransaction().commit();

    }


}
