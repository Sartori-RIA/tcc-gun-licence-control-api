package br.gov.pf.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by sartori on 13/07/17.
 */
@Entity
@Table(name = "exams")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Exam extends AbstractEntity {

    @ManyToOne
    private @NotNull ExamCategory examCategory;

    @Column(name = "data")
    private @Future Date date;

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
        return this.examCategory;
    }

    public void setExamCategory(ExamCategory examCategory) {
        this.examCategory = examCategory;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getResultDescription() {
        return this.resultDescription;
    }

    public void setResultDescription(String resultDescription) {
        this.resultDescription = resultDescription;
    }
}
