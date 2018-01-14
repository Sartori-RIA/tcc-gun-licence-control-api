package br.gov.pf.model.entity;

import br.gov.pf.util.BCrypt;

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
    //@CPF//TODO LEMBRAR DE DESCOMENTAR O VALIDADOR DE CPF
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
    @ManyToOne(fetch = FetchType.EAGER)
    private UserRole role;

    @ManyToOne
    private License license;

    @ManyToOne
    private Exam exam;

    @OneToMany
    @JoinColumn(name = "description")
    private List<Gun> gun;

    @NotNull
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

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }


    public List<Gun> getGun() {
        return gun;
    }

    public void setGun(List<Gun> gun) {
        this.gun = gun;
    }

    @PrePersist
    public void prePersist() {
        this.setPassword(BCrypt.hashpw(this.getPassword(), BCrypt.gensalt(5)));
    }

}
