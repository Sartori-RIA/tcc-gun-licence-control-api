package br.gov.pf.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "exam_category")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExamCategory extends AbstractEntity {


    @Column(name = "description")
    private @NotNull String description;

    public ExamCategory() {
    }

    public ExamCategory(@NotNull String description) {
        this.description = description;
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
