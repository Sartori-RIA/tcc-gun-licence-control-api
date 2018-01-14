package br.gov.pf.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "cities")
public class City extends AbstractEntity{

    @Column(name = "description")
    private String description;

    @ManyToOne
    private State state;

    public City() {
    }

    public City(String description, State state) {
        this.description = description;
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
