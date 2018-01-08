package br.gov.pf.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "licencas_categorias")
public class LicenceCategory  extends AbstractEntity  implements Serializable {


    @NotNull(message = "a campo deve possuir uma descricao")
    @Column(name = "descricao")
    private String description;


    public LicenceCategory(@NotNull(message = "a campo deve possuir uma descricao") String description) {
        this.description = description;
    }

    public LicenceCategory() {
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
