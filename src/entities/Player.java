package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author carls
 */
@Entity
@Table(name = "player")
public class Player extends EntityBase implements Serializable {

    private static final long serialVersionUID = 1L;


    @ManyToMany
    private Collection<Videogame> videogames;

    public Collection<Videogame> getVideogames() {
        return videogames;
    }

    public void setVideogames(Collection<Videogame> achievements) {
        this.videogames = achievements;
    }

    @Column(nullable = false, name = "name", length = 500)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "entities.Player[ id=" + id + " ]";
    }

}
