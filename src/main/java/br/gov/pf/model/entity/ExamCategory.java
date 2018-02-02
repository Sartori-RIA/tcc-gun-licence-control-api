package br.gov.pf.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "exam_category")
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
