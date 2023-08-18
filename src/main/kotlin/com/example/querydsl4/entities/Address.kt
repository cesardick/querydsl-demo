package com.example.querydsl4.entities

import jakarta.persistence.*
import org.jetbrains.annotations.NotNull
import java.util.*

enum class AddressType {
    PRIMARY,
    WORK,
    MAIL
}

@Entity
data class Address(

        @Id
        var id: String = UUID.randomUUID().toString(),

        @get:NotNull
        @Column(length = 255, nullable = false)
        var street: String = "",

        @get:NotNull
        @Column(length = 255, nullable = false)
        var city: String = "",

        @get:NotNull
        @Column(length = 255, nullable = false)
        var uf: String = "",

        @Enumerated(EnumType.STRING)
        @get:NotNull
        @Column(length = 255, nullable = false)
        var type: AddressType = AddressType.PRIMARY,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "person_id")
        val person: Person = Person()
) {
}