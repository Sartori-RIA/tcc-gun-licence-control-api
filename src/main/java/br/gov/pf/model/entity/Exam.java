package br.gov.pf.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by sartori on 13/07/17.
 */
@Entity
@Table(name = "exams")
public class Exam extends AbstractEntity implements Serializable {

    @NotNull
    @ManyToOne
    private ExamCategory examCategory;

    @Future
    @Column(name = "data")
    private Date date;

    @Column(name = "result")
    private boolean status;

    @Column(name = "result_description")
    private String resultDescription;


    public Exam() {
    }


    public Exam(@NotNull ExamCategory examCategory, @Future Date date, boolean status, String resultDescription) {
        this.examCategory = examCategory;
        this.date = date;
        this.status = status;
        this.resultDescription = resultDescription;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getResultDescription() {
        return resultDescription;
    }

    public void setResultDescription(String resultDescription) {
        this.resultDescription = resultDescription;
    }
}
