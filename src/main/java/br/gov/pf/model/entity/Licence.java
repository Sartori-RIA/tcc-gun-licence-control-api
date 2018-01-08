package br.gov.pf.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by sartori on 13/07/17.
 */
@Entity
@Table(name = "licenca")
public class Licence  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "a licenca deve possuir uma descricao")
    @Column(name = "descricao")
    private String description;

    @NotNull(message = "a licenca deve possuir uma categoria")
    @ManyToOne
    @JoinColumn(name = "categoria")
    private LicenceCategory licenceCategory;

    @NotNull(message = "a licenca deve possuir uma validade")
    @Column(name = "validade")
    @Future
    private Date shelfLife;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    public Licence() {
    }

    public Licence(@NotNull(message = "a licenca deve possuir uma descricao") String description,
                   @NotNull(message = "a licenca deve possuir uma categoria") LicenceCategory licenceCategory,
                   @NotNull(message = "a licenca deve possuir uma validade") @Future Date shelfLife) {
        this.description = description;
        this.licenceCategory = licenceCategory;
        this.shelfLife = shelfLife;
    }

    /**
     * GETS E SETS
     */
    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LicenceCategory getLicenceCategory() {
        return licenceCategory;
    }

    public Date getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(Date shelfLife) {
        this.shelfLife = shelfLife;
    }

    public void setLicenceCategory(LicenceCategory licenceCategory) {
        this.licenceCategory = licenceCategory;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    @PrePersist
    public void setCreatedAt() {
        this.createdAt = new Date();
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    @PreUpdate
    public void setUpdatedAt() {
        this.updatedAt = new Date();
    }
}
