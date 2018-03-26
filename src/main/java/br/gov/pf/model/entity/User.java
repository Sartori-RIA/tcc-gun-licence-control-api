package br.gov.pf.model.entity;

import br.gov.pf.util.BCrypt;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.br.CPF;

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

    @Column(name = "fathers_name")
    private @NotNull String fathersName;

    @Column(name = "mothers_name")
    private @NotNull String mothersName;

    @Column(name = "nationality")
    private @NotNull String nationality;

    @Column(name = "naturalness")
    private @NotNull String naturalness;

    @ManyToOne
    private @NotNull Gender gender;

    @Column(name = "CPF")
    private @NotNull String cpf;

    @Column(name = "RG")
    private @NotNull String rg;

    @Column(name = "RG_issuing_body")
    private @NotNull String rgIssuingBody;

    @Column(name = "rg_uf")
    private @NotNull String rgUf;

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
    @JoinTable(name = "address_user",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "address_id", referencedColumnName = "id"))
    private List<Address> addressList;

    @Column(name = "criminal_recors")
    private Boolean criminalRecord;

    @Column(name = "responding_process")
    private Boolean respondingProcess;

    public User() {
    }

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

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getMothersName() {
        return mothersName;
    }

    public void setMothersName(String mothersName) {
        this.mothersName = mothersName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNaturalness() {
        return naturalness;
    }

    public void setNaturalness(String naturalness) {
        this.naturalness = naturalness;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getRgIssuingBody() {
        return rgIssuingBody;
    }

    public void setRgIssuingBody(String rgIssuingBody) {
        this.rgIssuingBody = rgIssuingBody;
    }

    public String getRgUf() {
        return rgUf;
    }

    public void setRgUf(String rgUf) {
        this.rgUf = rgUf;
    }

    public Boolean getCriminalRecord() {
        return criminalRecord;
    }

    public void setCriminalRecord(Boolean criminalRecord) {
        this.criminalRecord = criminalRecord;
    }

    public Boolean getRespondingProcess() {
        return this.respondingProcess;
    }

    public void setRespondingProcess(Boolean respondingProcess) {
        this.respondingProcess = respondingProcess;
    }

    @PrePersist
    public void prePersist() {
        setPassword(BCrypt.hashpw(getPassword(), BCrypt.gensalt(5)));
        setCriminalRecord(false);
        setRespondingProcess(false);
    }

}
