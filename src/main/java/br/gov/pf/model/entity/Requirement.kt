package br.gov.pf.model.entity;

import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import javax.persistence.*

@Table(name = "requirements")
@Entity
class Requirement : AbstractEntity() {

    @Column(name = "minimal_age")
    var minimalAge: Int = 0

    @Column(name = "criminal_records")
    var criminalRecors: Boolean = false

    @Column(name = "responding_process")
    var respondingProcess: Boolean = false

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "requirements_exam_category",
            joinColumns = [JoinColumn(name = "requirement_id", referencedColumnName = "id")],
            inverseJoinColumns = [JoinColumn(name = "exam_category_id", referencedColumnName = "id")])
    var exams: List<ExamCategory> = ArrayList()
}
