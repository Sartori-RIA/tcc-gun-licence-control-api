package br.gov.pf.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usuario_categorias")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="description")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "o campo deve possuir uma descricao")
    @Column(name = "descricao")
    private String description;


    public UserCategory(String description) {
        this.description = description;
    }

    public UserCategory() {
    }


    /** GETS E SETS */
    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
