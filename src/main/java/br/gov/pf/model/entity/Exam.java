package br.gov.pf.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by sartori on 13/07/17.
 */
@Entity
@Table(name = "exams")
public class Exam extends AbstractEntity {

    @ManyToOne
    private @NotNull ExamCategory examCategory;

    @Column(name = "data")
    private @Future Date date;

    @Column(name = "result")
    private Boolean status;

    @Column(name = "result_description")
    private String resultDescription;

    @ManyToOne
    private @NotNull User examinator;

    @ManyToOne
    private @NotNull User civil;


    public Exam() {
    }

    /**
     * GETS E SETS
     */

    public ExamCategory getExamCategory() {
        return examCategory;
    }

    public void setExamCategory(ExamCategory examCategory) {
        this.examCategory = examCategory;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean isStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getResultDescription() {
        return resultDescription;
    }

    public void setResultDescription(String resultDescription) {
        this.resultDescription = resultDescription;
    }

    public User getExaminator() {
        return this.examinator;
    }

    public void setExaminator(User examinator) {
        this.examinator = examinator;
    }

    public User getCivil() {
        return this.civil;
    }

    public void setCivil(User civil) {
        this.civil = civil;
    }
}
