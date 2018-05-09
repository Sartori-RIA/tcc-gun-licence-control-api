package br.gov.pf.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
class Country : AbstractEntity() {
    @Column(name = "description")
    var description: String = ""
}