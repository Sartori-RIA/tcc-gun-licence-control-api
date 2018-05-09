package br.gov.pf.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "exam_category")
class ExamCategory : AbstractEntity() {


    @Column(name = "description")
    @NotNull
    var description: String = ""

    @ManyToOne
    @NotNull
    var role: UserRole = UserRole()
}
