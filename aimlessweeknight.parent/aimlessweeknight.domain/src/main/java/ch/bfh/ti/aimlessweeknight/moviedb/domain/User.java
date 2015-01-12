package ch.bfh.ti.aimlessweeknight.moviedb.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Christian on 11.11.2014.
 */
@Entity
public class User {
    private Long id;

    @GeneratedValue
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String username;

    @Basic
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String email;

    @Basic
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private Collection<Possession> possessions;

    @OneToMany(mappedBy = "user")
    public Collection<Possession> getPossessions() {
        return possessions;
    }

    public void setPossessions(Collection<Possession> possessions) { this.possessions = possessions; }
}
