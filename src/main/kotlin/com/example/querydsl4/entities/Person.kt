package com.example.querydsl4.entities

import jakarta.persistence.*
import org.jetbrains.annotations.NotNull
import java.time.LocalDateTime
import java.util.*

enum class Gender {
    MALE,
    FEMALE
}

@Entity
data class Person(
        @Id
        var id: String = UUID.randomUUID().toString(),

        @get:NotNull
        @Column(length = 255, nullable = false)
        var name: String = "",

        @get:NotNull
        @Column(length = 255)
        var birthDate: LocalDateTime? = null,

        @Enumerated(EnumType.STRING)
        @get:NotNull
        @Column(length = 255)
        var gender: Gender? = null,

        @get:NotNull
        @Column(length = 255, nullable = false, unique = true)
        var email: String = "",

        @get:NotNull
        var age: Int = 0,

        @get:NotNull
        var marriedYears: Int = 0
) {
    @OneToMany(mappedBy = "person")
    var addresses: MutableSet<Address> = mutableSetOf()
}
