package br.gov.pf.model.entity;

import br.gov.pf.util.BCrypt;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sartori on 13/07/17.
 */
@Entity
@Table(name = "users")
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

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "license_user",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "license_id", referencedColumnName = "id"))
    private List<License> licenseList;

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "exam_user",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "exam_id", referencedColumnName = "id"))
    private List<Exam> examList;

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "gun_user",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "gun_id", referencedColumnName = "id"))
    private List<Gun> gunList;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "address_user",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "address_id", referencedColumnName = "id"))
    private List<Address> addressList;


    public User() {
    }

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

    public List<License> getLicenseList() {
        return this.licenseList;
    }

    public void setLicenseList(List<License> licenseList) {
        this.licenseList = licenseList;
    }

    public List<Exam> getExamList() {
        return this.examList;
    }

    public void setExamList(List<Exam> examList) {
        this.examList = examList;
    }

    public List<Gun> getGunList() {
        return this.gunList;
    }

    public void setGunList(List<Gun> gunList) {
        this.gunList = gunList;
    }

    public List<Address> getAddressList() {
        return this.addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    @PrePersist
    public void prePersist() {
        this.setPassword(BCrypt.hashpw(this.getPassword(), BCrypt.gensalt(5)));
    }

}
