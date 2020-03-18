package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author carls
 */
@Entity
@Table(name = "videogame")
public class Videogame extends EntityBase implements Serializable {

    private static final long serialVersionUID = 1L;


    @Column(nullable = false)
    private int rating;

    @OneToMany(mappedBy = "videogame", cascade = CascadeType.PERSIST)
    private Collection<Achievement> achievements;

    public Collection<Achievement> getAchievements() {
        return achievements;
    }

    public void setAchievements(Collection<Achievement> achievements) {
        this.achievements = achievements;
    }

    @ManyToMany
    private Collection<Player> players;

    public Collection<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Collection<Player> player) {
        this.players = player;
    }

    public void addPlayer(Player player) {
        if (this.players == null) {
            this.players = new ArrayList<>();
        }
        this.players.add(player);
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


    @Column(name = "name", nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Videogame() {
        this.achievements = new HashSet();
    }

    public void addAchievement(Achievement a) {
        a.setVideogame(this);
        this.achievements.add(a);
    }

       @Override
    public String toString() {
        return "entities.Achievement[ id=" + id + " ]";
    }


}
