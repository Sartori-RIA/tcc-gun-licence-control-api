package br.gov.pf.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "users_roles")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRole extends AbstractEntity {

    @Column(name = "description")
    private @NotNull String description;

    public UserRole(@NotNull String description) {
        this.description = description;
    }

    public UserRole() {
    }

    /**
     * GETS E SETS
     */
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
