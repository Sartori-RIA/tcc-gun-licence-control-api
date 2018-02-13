package br.gov.pf.model.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Table(name = "requirements")
@Entity
public class Requirement extends AbstractEntity {

    @Column(name = "minimal_age")
    private Integer minimalAge;

    @Column(name = "criminal_records")
    private Boolean criminalRecors;

    @Column(name = "responding_process")
    private Boolean respondingProcess;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<ExamCategory> exams;

    public Integer getMinimalAge() {
        return this.minimalAge;
    }

    public void setMinimalAge(Integer minimalAge) {
        this.minimalAge = minimalAge;
    }

    public List<ExamCategory> getExams() {
        return this.exams;
    }

    public void setExams(List<ExamCategory> exams) {
        this.exams = exams;
    }

    public Boolean getCriminalRecors() {
        return this.criminalRecors;
    }

    public void setCriminalRecors(Boolean criminalRecors) {
        this.criminalRecors = criminalRecors;
    }

    public Boolean getRespondingProcess() {
        return this.respondingProcess;
    }

    public void setRespondingProcess(Boolean respondingProcess) {
        this.respondingProcess = respondingProcess;
    }
}
