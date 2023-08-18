package com.example.querydsl4.repository

import ampli.commons.jpa.repository.ProjectionRepository
import com.example.querydsl4.entities.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor

interface PersonRepository: JpaRepository<Person, String>, QuerydslPredicateExecutor<Person>, ProjectionRepository<Person, String> {
}