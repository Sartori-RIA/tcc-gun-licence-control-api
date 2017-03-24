package br.gov.pf.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by sartori on 15/03/17.
 */

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="name")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Long getId() {
        return id;
    }
}
