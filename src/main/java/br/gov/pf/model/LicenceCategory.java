package br.gov.pf.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "licencas_categorias")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="description")
public class LicenceCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "a campo deve possuir uma descricao")
    @Column(name = "descricao")
    private String description;

    public LicenceCategory(String description) {
        this.description = description;
    }

    public LicenceCategory() {
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
