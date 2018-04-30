package br.gov.pf.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cities")
public class City extends AbstractEntity {

    @Column(name = "description")
    private String description;

    @ManyToOne
    private State state;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public State getState() {
        return this.state;
    }

    public void setState(State state) {
        this.state = state;
    }
}