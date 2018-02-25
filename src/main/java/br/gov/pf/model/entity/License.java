package br.gov.pf.model.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.util.*;

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

    @ManyToOne
    private Address address;

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
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
        return category;
    }

    public void setCategory(LicenseCategory category) {
        this.category = category;
    }

    public Date getShelfLife() {
        return this.shelfLife;
    }

    public void setShelfLife(Date shelfLife) {
        this.shelfLife = shelfLife;
    }

    public String getSerial() {
        return this.serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Gun getGun() {
        return gun;
    }

    public void setGun(Gun gun) {
        this.gun = gun;
    }

    public List<Exam> getExamList() {
        return examList;
    }

    public void setExamList(List<Exam> examList) {
        this.examList = examList;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @PostUpdate
    public void postUpdate() {
        if (verifyExams()) {
            setStatus(true);
            setShelfLife(this.setExpirateDate());
        }
    }

    @PostPersist
    public void postPersist() {
        setSerial(getId() + "-" + UUID.randomUUID());
    }

    private Boolean verifyExams() {
        ArrayList<Exam> exams = new ArrayList<>();
        if (getExamList() != null) {
            for (ExamCategory examCategory : getCategory().getRequirement().getExams())
                for (Exam exam : getExamList())
                    if (exam.getExamCategory().equals(examCategory) && exam.getStatus())
                        exams.add(exam);
            return exams.size() == getCategory().getRequirement().getExams().size();
        }
        return Boolean.FALSE;
    }

    private Date setExpirateDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, getCategory().getYearsExpirate());
        return calendar.getTime();
    }

}
