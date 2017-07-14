package br.gov.pf.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by sartori on 13/07/17.
 */
@Entity
@Table(name = "usuario")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="name")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    @CPF
    private Integer cpf;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String cep;
    @NotNull
    @Min(5) @Max(30)
    private String street;
    @NotNull
    @Min(5) @Max(30)
    private String neighborhood;
    @NotNull
    @Min(2) @Max(15)
    private String state;
    @NotNull
    @Past
    private Date dateOfBirth;
    @NotNull
    private int type;
    @ManyToOne
    private Licence licence;
    @ManyToOne
    private Exam exam;
    @ManyToOne
    private Gun gun;

    public User() {
    }

}
