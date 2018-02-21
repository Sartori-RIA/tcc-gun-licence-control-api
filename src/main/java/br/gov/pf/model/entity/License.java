package br.gov.pf.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by sartori on 13/07/17.
 */
@Entity
@Table(name = "licenses")
public class License extends AbstractEntity {

    @ManyToOne
    private @NotNull LicenseCategory category;

    @Column(name = "shelf_life")
    private @Future Date shelfLife;

    @Column(name = "serial_number")
    private String serial;

    @Column(name = "status")
    private boolean status;

    @ManyToOne
    private @NotNull User user;

    @ManyToOne
    private Gun gun;

    @OneToMany
    @JoinTable(name = "licence_exam",
            joinColumns = @JoinColumn(name = "licence_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "exam_id", referencedColumnName = "id"))
    private List<Exam> examList;

    public License() {
    }

    /**
     * GETS E SETS
     */

    public LicenseCategory getCategory() {
        return this.category;
    }

    public void setCategory(LicenseCategory category) {
        this.category = category;
    }

    public Date getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(Date shelfLife) {
        this.shelfLife = shelfLife;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Gun getGun() {
        return this.gun;
    }

    public void setGun(Gun gun) {
        this.gun = gun;
    }

    public List<Exam> getExamList() {
        return this.examList;
    }

    public void setExamList(List<Exam> examList) {
        this.examList = examList;
    }

    @PostUpdate
    public void postUpdate() {
        setSerial(getId() + "-" + UUID.randomUUID());
    }
}
