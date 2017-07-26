package br.gov.pf.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "exame_categoria")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="name")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExamCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "a categoria deve possuir uma descricao")
    @Column(name = "description")
    private String description;

    public ExamCategory() {
    }

    public ExamCategory(String description) {
        this.description = description;
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
