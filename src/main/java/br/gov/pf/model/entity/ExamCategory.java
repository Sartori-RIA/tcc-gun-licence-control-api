package br.gov.pf.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "exam_category")
public class ExamCategory extends AbstractEntity {


    @Column(name = "description")
    private @NotNull String description;

    @ManyToOne
    private @NotNull UserRole role;

    public ExamCategory() {
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

    public UserRole getRole() {
        return this.role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
