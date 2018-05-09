package br.gov.pf.model.entity;

import de.mkammerer.argon2.Argon2Factory
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Past
import kotlin.collections.ArrayList

/**
 * Created by sartori on 13/07/17.
 */
@Entity
@Table(name = "users")
class User : AbstractEntity() {

    @Column(name = "name")
    @NotNull
    var name: String = ""

    @Column(name = "fathers_name")
    @NotNull
    var fathersName: String = ""

    @Column(name = "mothers_name")
    @NotNull
    var mothersName: String = ""

    @Column(name = "nationality")
    @NotNull
    var nationality: String = ""

    @Column(name = "naturalness")
    @NotNull
    var naturalness: String = ""

    @ManyToOne
    @NotNull
    var gender: Gender = Gender()

    @Column(name = "CPF")
    @NotNull
    var cpf: String = ""

    @Column(name = "RG")
    @NotNull
    var rg: String = ""

    @Column(name = "RG_issuing_body")
    @NotNull
    var rgIssuingBody: String = ""

    @Column(name = "rg_uf")
    @NotNull
    var rgUf: String = ""

    @Column(name = "email")
    @NotNull
    var email: String = ""

    @Column(name = "password")
    @NotNull
    var password: String = ""

    @Column(name = "date_of_birth")
    @Past
    @NotNull
    var dateOfBirth: Date = Date()

    @ManyToOne
    @NotNull
    var role: UserRole = UserRole()

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "address_user",
            joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")],
            inverseJoinColumns = [JoinColumn(name = "address_id", referencedColumnName = "id")])
    var addressList: List<Address> = ArrayList()

    @Column(name = "criminal_recors")
    var criminalRecord: Boolean = false

    @Column(name = "responding_process")
    var respondingProcess: Boolean = false


    @PrePersist
    fun prePersist() {
        val argon2 = Argon2Factory.create()
        val hash = argon2.hash(2, 65536, 1, this.password)
        this.password = hash
    }

}
