package br.gov.pf.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "usuario_categorias")
public class UserRole extends AbstractEntity implements Serializable {


    @NotNull(message = "o campo deve possuir uma descricao")
    @Column(name = "descricao")
    private String description;


    public UserRole(@NotNull(message = "o campo deve possuir uma descricao") String description) {
        this.description = description;
    }

    public UserRole() {
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
