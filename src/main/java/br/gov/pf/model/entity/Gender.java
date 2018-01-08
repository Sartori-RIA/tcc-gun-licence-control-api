package br.gov.pf.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "genero")
public class Gender implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "o campo deve possuir uma descricao")
    @Column(name = "descricao")
    private String description;

    @NotNull(message = "o campo deve possuir uma abreviacao")
    @Size.List({
            @Size(min = 1, message = "minimo de 1(um) caracter"),
            @Size(max = 1, message = "maximo de 1(um) caracter")
    })
    @Column(name = "Abreviacao")
    private String abbrev;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    public Gender() {
    }

    public Gender(@NotNull(message = "o campo deve possuir uma descricao") String description, @NotNull(message = "o campo deve possuir uma abreviacao") @Size.List({
            @Size(min = 1, message = "minimo de 1(um) caracter"),
            @Size(max = 1, message = "maximo de 1(um) caracter")
    }) String abbrev) {
        this.description = description;
        this.abbrev = abbrev;
    }

    /**
     * GETS E SETS
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }

    public Long getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    @PrePersist
    public void setCreatedAt() {
        this.createdAt = new Date();
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    @PreUpdate
    public void setUpdatedAt() {
        this.updatedAt = new Date();
    }
}
