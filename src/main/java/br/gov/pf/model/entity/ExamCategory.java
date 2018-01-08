package br.gov.pf.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "exame_categoria")
public class ExamCategory  extends AbstractEntity  implements Serializable {



    @NotNull(message = "a categoria deve possuir uma descricao")
    @Column(name = "description")
    private String description;

    public ExamCategory() {
    }

    public ExamCategory(@NotNull(message = "a categoria deve possuir uma descricao") String description) {
        this.description = description;
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

}
