package br.gov.pf.model.entity;

import br.gov.pf.util.BCrypt;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.List;

/**
 * Created by sartori on 13/07/17.
 */
@Entity
@Table(name = "users")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends AbstractEntity {

    @Column(name = "name")
    private @NotNull String name;

    @ManyToOne
    private @NotNull Gender gender;

    @Column(name = "CPF") //@CPF //TODO remover este comentario quando pronto
    private @NotNull String cpf;

    @Column(name = "email")
    private @NotNull String email;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @Column(name = "date_of_birth")
    private @NotNull @Past Date dateOfBirth;

    @ManyToOne
    private UserRole role;

    @OneToMany
    private List<License> license;

    @ManyToMany
    private List<Exam> exam;

    @OneToMany
    private List<Gun> gun;

    @ManyToMany
    @JoinTable(name = "address",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "address_id", referencedColumnName = "id")})
    private List<Address> addressList;

    public User() {
    }

    /**
     * GETS E SETS
     */

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public UserRole getRole() {
        return this.role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public void setGun(List<Gun> gun) {
        this.gun = gun;
    }

    @PrePersist
    public void prePersist() {
        setPassword(BCrypt.hashpw(getPassword(), BCrypt.gensalt(5)));
    }

}
