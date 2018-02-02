package br.gov.pf.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Size.List;

@Entity
@Table(name = "genders")
public class Gender extends AbstractEntity {


    @Column(name = "description")
    private @NotNull String description;

    @Column(name = "abbrev")
    private @NotNull @List({
            @Size(min = 1),
            @Size(max = 1)
    }) String abbrev;

    public Gender() {
    }

    public Gender(@NotNull String description,
                  @NotNull @List({
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
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAbbrev() {
        return this.abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }

}
