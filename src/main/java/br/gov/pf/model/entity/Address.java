package br.gov.pf.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Size.List;

@Entity
@Table(name = "address")
public class Address extends AbstractEntity {

    @Column(name = "cep")
    private @NotNull String cep;

    @Column(name = "street")
    private @NotNull @List({
            @Size(min = 5),
            @Size(max = 100)
    }) String street;

    @Column(name = "neighborhood")
    private @NotNull @List({
            @Size(min = 5),
            @Size(max = 100)
    }) String neighborhood;

    @Column(name = "addressNumber")
    private @NotNull String addressNumber;

    @Column(name = "complement")
    private String complement;

    @ManyToOne
    private @NotNull City city;

    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNeighborhood() {
        return this.neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getAddressNumber() {
        return this.addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getComplement() {
        return this.complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public City getCity() {
        return this.city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
