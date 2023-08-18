package com.example.querydsl4

import com.example.querydsl4.repository.impl.CustomRepositoryFactoryBean
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = CustomRepositoryFactoryBean::class)
class Querydsl4Application

fun main(args: Array<String>) {
	runApplication<Querydsl4Application>(*args)
}
