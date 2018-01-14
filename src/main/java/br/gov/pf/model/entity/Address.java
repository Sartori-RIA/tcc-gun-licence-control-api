package br.gov.pf.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "address")
public class Address extends AbstractEntity{

    @NotNull
    @Column(name = "cep")
    private String cep;

    @NotNull
    @Size.List({
            @Size(min = 5),
            @Size(max = 100)
    })
    @Column(name = "street")
    private String street;

    @NotNull
    @Size.List({
            @Size(min = 5),
            @Size(max = 100)
    })
    @Column(name = "neighborhood")
    private String neighborhood;

    @NotNull
    @Column(name = "addressNumber")
    private String addressNumber;

    @Column(name = "complement")
    private String complement;

    @ManyToOne
    @NotNull
    private City city;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
