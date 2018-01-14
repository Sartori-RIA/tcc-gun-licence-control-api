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
@Table(name = "exame")
public class Exam extends AbstractEntity implements Serializable {

    @NotNull(message = "o exame deve possuir uma categoria")
    @ManyToOne
    @JoinColumn(name = "exame")
    private ExamCategory examCategory;

    @Future
    @Column(name = "data")
    private Date date;

    @Column(name = "resultado")
    private boolean status;


    public Exam() {
    }

    public Exam(@NotNull(message = "o exame deve possuir uma categoria") ExamCategory examCategory,
                @Future Date date,
                boolean status) {
        this.examCategory = examCategory;
        this.date = date;
        this.status = status;
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


}
