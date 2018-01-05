package br.gov.pf.model.entity;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by sartori on 13/07/17.
 */
@Entity
@Table(name = "usuario")
public class User extends AbstractEntity<Long> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "o usuario deve possuir um nome")
    @Column(name = "nome")
    private String name;

    @ManyToOne
    @NotNull(message = "o usuario deve possuir um sexo")
    @JoinColumn(name = "sexo")
    private Sex sex;

    @NotNull(message = "o usuario deve possuir um CPF")
    @CPF
    private String cpf;

    @NotNull(message = "o usuario deve possuir um e-mail")
    private String email;

    @NotNull(message = "o usuario deve possuir uma senha")
    @Column(name = "senha")
    private String password;

    @NotNull
    private String cep;

    @NotNull(message = "o usuario deve residir em um rua")
    @Min(5)
    @Max(30)
    @Column(name = "rua")
    private String street;

    @NotNull(message = "o usuario deve residir em uma cidade")
    @Min(5)
    @Max(30)
    @Column(name = "bairro")
    private String neighborhood;

    @NotNull(message = "o usuario deve residir em um estado")
    @Size.List({
            @Size(min = 2, message = "minimo de 2(dois) caracter"),
            @Size(max = 15, message = "maximo de 15(quinze) caracteres")
    })
    @Column(name = "estado")
    private String state;

    @NotNull
    @Past
    @Column(name = "data_aniversario")
    private Date dateOfBirth;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull(message = "o usuario deve possuir um nivel de acesso")
    @JoinColumn(name = "tipo_usuario")
    private UserRole role;

    @ManyToOne
    @JoinColumn(name = "licenca")
    private Licence licence;

    @ManyToOne
    @JoinColumn(name = "exames")
    private Exam exam;

    @ManyToOne
    @JoinColumn(name = "armas")
    private Gun gun;

    public User() {
    }

    public User(String name, Sex sex, String cpf, String email, String password, String cep, String street,
                String neighborhood, String state, Date dateOfBirth, UserRole role,
                Licence licence, Exam exam, Gun gun) {
        this.name = name;
        this.sex = sex;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.cep = cep;
        this.street = street;
        this.neighborhood = neighborhood;
        this.state = state;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
        this.licence = licence;
        this.exam = exam;
        this.gun = gun;
    }

    /**
     * GETS E SETS
     */
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Licence getLicence() {
        return licence;
    }

    public void setLicence(Licence licence) {
        this.licence = licence;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Gun getGun() {
        return gun;
    }

    public void setGun(Gun gun) {
        this.gun = gun;
    }
}
