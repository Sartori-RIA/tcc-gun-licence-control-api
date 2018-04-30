package br.gov.pf.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cities")
data class City(
        @Column(name = "description")
        var description: String = "",
        @ManyToOne
        var state: State = State()) : AbstractEntity()