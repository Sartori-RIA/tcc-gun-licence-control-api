package br.gov.pf.model.entity;

import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import java.util.*
import javax.persistence.*
import javax.validation.constraints.Future
import javax.validation.constraints.NotNull
import kotlin.collections.ArrayList

/**
 * Created by sartori on 13/07/17.
 */
@Entity
@Table(name = "licenses")
class License : AbstractEntity() {

    @ManyToOne
    @NotNull
    var category: LicenseCategory = LicenseCategory()

    @Column(name = "shelf_life")
    @Future
    var shelfLife: Date = Date()

    @Column(name = "serial_number")
    var serial: String = ""

    @Column(name = "status")
    var status: Boolean = false

    @ManyToOne
    @NotNull
    var user: User = User()

    @ManyToOne
    var address: Address = Address()

    @OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "licence_exam",
            joinColumns = [JoinColumn(name = "licence_id", referencedColumnName = "id")],
            inverseJoinColumns = [JoinColumn(name = "exam_id", referencedColumnName = "id")])
    var examList: List<Exam> = ArrayList()


    @PostPersist
    fun postPersist() {
        this.serial = "${this.id}-${UUID.randomUUID()}"
    }

}
