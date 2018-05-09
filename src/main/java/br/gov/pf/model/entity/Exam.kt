package br.gov.pf.model.entity;

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.validation.constraints.Future
import javax.validation.constraints.NotNull

/**
 * Created by sartori on 13/07/17.
 */
@Entity
@Table(name = "exams")
class Exam : AbstractEntity() {

    @ManyToOne
    @NotNull
    var examCategory: ExamCategory = ExamCategory()

    @Column(name = "data")
    @Future
    var date: Date = Date()

    @Column(name = "result")
    var status: Boolean = false

    @Column(name = "result_description")
    var resultDescription: String = ""

    @ManyToOne
    @NotNull
    var examinator: User = User()

    @ManyToOne
    @NotNull
    var civil: User = User()
}
