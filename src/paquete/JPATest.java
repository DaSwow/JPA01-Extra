package paquete;

import entities.Achievement;
import entities.Videogame;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class JPATest {


    public static void main(String[] args) {
       
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("JPA1PU");
        EntityManager entityManager = managerFactory.createEntityManager();
     
        entityManager.getTransaction().begin();
        Videogame game = new Videogame();
        game.setName("Gears of War");
        game.setRating(4);
        
        Achievement achievement1 = new Achievement();
        achievement1.setName("Level 1");
        game.addAchievement(achievement1);
        achievement1.setVideogame(game);
        entityManager.persist(game);
        entityManager.persist(achievement1);
        
        entityManager.getTransaction().commit();
      
        TypedQuery<Videogame> query = 
                entityManager.createQuery(
                    "SELECT v FROM Videogame v WHERE v.rating >= :rating", Videogame.class);
        query.setParameter("rating", 4);
        List<Videogame> list = query.getResultList();
    }
    
}
