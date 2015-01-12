package ch.bfh.ti.aimlessweeknight.moviedb.service.dto;

import ch.bfh.ti.aimlessweeknight.moviedb.domain.Possession;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Christian on 11.11.2014.
 */

public class UserDTO {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private Collection<PossessionDTO> possessions;

    public Collection<PossessionDTO> getPossessions() {
        return possessions;
    }

    public void setPossessions(Collection<PossessionDTO> possessions) { this.possessions = possessions; }
}
