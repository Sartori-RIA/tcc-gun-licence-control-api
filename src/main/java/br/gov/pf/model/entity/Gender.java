package br.gov.pf.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "genders")
public class Gender extends AbstractEntity implements Serializable {


    @NotNull
    @Column(name = "description")
    private String description;

    @NotNull
    @Size.List({
            @Size(min = 1),
            @Size(max = 1)
    })
    @Column(name = "abbrev")
    private String abbrev;

    public Gender() {
    }

    public Gender(@NotNull String description,
                  @NotNull @Size.List({
                          @Size(min = 1),
                          @Size(max = 1)
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

}
