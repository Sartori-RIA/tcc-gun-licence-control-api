package br.gov.pf.model.entity;

import java.io.Serializable
import java.util.*
import javax.persistence.*

/**
 * Created by sartori on 13/07/17.
 */

@MappedSuperclass
abstract class AbstractEntity : Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long = 0L

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    var createdAt: Date = Date()

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    var updatedAt: Date = Date()


    @PrePersist
    fun perPersist() {
        this.createdAt = Date()
        this.updatedAt = Date()
    }

    @PreUpdate
    fun preUpdate() {
        this.updatedAt = Date()
    }
}