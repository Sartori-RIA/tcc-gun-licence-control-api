package br.gov.pf.model.entity;

import br.gov.pf.util.BCrypt;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by sartori on 13/07/17.
 */
@Entity
@Table(name = "users")
public class User extends AbstractEntity implements Serializable {


    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @ManyToOne
    private Gender gender;

    @NotNull
    @Column(name = "CPF")
    //@CPF //TODO remover este comentario quando pronto
    private String cpf;

    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull
    @Past
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @NotNull
    @ManyToOne
    private UserRole role;

    @OneToMany
    private List<License> license;

    @ManyToMany
    private List<Exam> exam;

    @OneToMany
    private List<Gun> gun;

    @OneToMany
    private List<Address> addressList;

    public User() {
    }

    /**
     * GETS E SETS
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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

    public void setGun(List<Gun> gun) {
        this.gun = gun;
    }

    @PrePersist
    public void prePersist() {
        this.setPassword(BCrypt.hashpw(this.getPassword(), BCrypt.gensalt(5)));
    }

}
