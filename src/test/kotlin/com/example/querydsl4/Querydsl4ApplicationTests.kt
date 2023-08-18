package com.example.querydsl4

import com.example.querydsl4.dto.CodeNameDto
import com.example.querydsl4.dto.PersonFilter
import com.example.querydsl4.dto.PersonWithMarriageAge
import com.example.querydsl4.entities.AddressType
import com.example.querydsl4.entities.Person
import com.example.querydsl4.entities.QAddress
import com.example.querydsl4.entities.QPerson
import com.example.querydsl4.repository.PersonRepository
import com.querydsl.core.BooleanBuilder
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime

@SpringBootTest
class Querydsl4ApplicationTests {

	@Autowired
	lateinit var personRepository: PersonRepository

	@Autowired
	lateinit var entityManager: EntityManager

	@Test
	fun findSimpleFilter() {
		//Filtrar pessoas com nome começando com uma letra, ignorando case.
		val query = QPerson.person.name.startsWithIgnoreCase("a");
		val persons = personRepository.findAll(query);
		Assertions.assertEquals(2, persons.count());
	}

	@Test
	fun findSimpleFilter2() {
		//Filtrar pessoas com idade entre 18 e 20 anos
		val query = QPerson.person.age.between(18, 20);
		val persons = personRepository.findAll(query);
		Assertions.assertEquals(2, persons.count());
	}

	@Test
	fun findMultipleFilter() {
		//Filtrar pessoas com idade entre 18 e 20 anos ou que o nome tenha a palavra aline (ignorando case)
		val query = QPerson.person.age.between(18, 20).or(
				QPerson.person.name.containsIgnoreCase("aline")
		);
		val persons = personRepository.findAll(query);
		Assertions.assertEquals(3, persons.count());
	}

	@Test
	fun filterBuilder() {

		//É possível construir a query dinamicamente tratando filtros opcionais:

		val exampleFilter = PersonFilter(name = "aline")

		val query = BooleanBuilder()

		//Podemos ter N atributos opcionais no filtro, sem muita confusão e sem a necessidade de múltiplos métodos.
		exampleFilter.name?.let { query.and(QPerson.person.name.containsIgnoreCase(it)) }
		exampleFilter.gender?.let { query.and(QPerson.person.gender.eq(it)) }
		exampleFilter.email?.let { query.and(QPerson.person.email.eq(it)) }

		val list = personRepository.findAll(query)

		Assertions.assertEquals(1, list.count());
		Assertions.assertEquals("Aline Jennifer Clarice da Silva", list.iterator().next().name);
	}

	@Test
	fun findSublistFilter() {
		//Filtrar pessoas chamadas Marcelo e que possuam algum endereço em SP
		val query = QPerson.person.name.startsWithIgnoreCase("marcelo").and(
				QPerson.person.addresses.any().uf.eq("SP")
		);
		val persons = personRepository.findAll(query);
		Assertions.assertEquals(1, persons.count());
	}

	@Test
	fun projectingResults() {

		//Escolher quais campos trazer do banco, nesse caso, o select montado busca apenas essas informações.

		val factory = JPAQueryFactory(entityManager)

		val names = factory
				.from(QPerson.person)
				.where(QPerson.person.name.startsWithIgnoreCase("aline"))
				.select(QPerson.person.name)
				.fetch()

		Assertions.assertEquals(1, names.count());
		Assertions.assertEquals("Aline Jennifer Clarice da Silva", names[0]);
	}

	@Test
	fun projectingResultsToEntity() {

		//Escolher quais campos trazer do banco, nesse caso, o select montado busca apenas essas informações e Mapeados para uma Classe a parte.

		val factory = JPAQueryFactory(entityManager)

		val projection = Projections.bean(
				CodeNameDto::class.java,
				QPerson.person.name,
				QPerson.person.id.`as`("code")
		)

		val names = factory
				.from(QPerson.person)
				.where(QPerson.person.name.startsWithIgnoreCase("aline"))
				.select(projection)
				.fetch()

		Assertions.assertEquals(1, names.count());
		Assertions.assertEquals("Aline Jennifer Clarice da Silva", names[0].name);
		Assertions.assertEquals("6665839a-8433-4c66-ae37-925d8e572018", names[0].code);
	}

	@Test
	fun projectingWithHelperRepository() {

		//Usamos uma implementação utilitária de repository para fazermos as projeções com menos código.
		val projection = Projections.bean(
				CodeNameDto::class.java,
				QPerson.person.name,
				QPerson.person.id.`as`("code")
		)

		//Person Repository extende a interface ProjectionRepository
		val names = personRepository.findAll(
				projection,
				QPerson.person.name.startsWithIgnoreCase("aline")
		)

		Assertions.assertEquals(1, names.count());
		Assertions.assertEquals("Aline Jennifer Clarice da Silva", names[0].name);
		Assertions.assertEquals("6665839a-8433-4c66-ae37-925d8e572018", names[0].code);
	}

	@Test
	fun aggregatingValuesOnProjection() {

		//Vamos descobrir a idade de casamento da pessoa, para isso, precisamos calcular age - marriedYears

		val factory = JPAQueryFactory(entityManager)

		val projection = Projections.bean(
				PersonWithMarriageAge::class.java,
				QPerson.person.id,
				QPerson.person.age.subtract(QPerson.person.marriedYears).`as`("marriageAge")
		)

		val names = factory
				.from(QPerson.person)
				.where(QPerson.person.id.eq("b7614764-6dbe-4ff9-8fcf-4b23d686ae64"))
				.select(projection)
				.fetch()

		Assertions.assertEquals(1, names.count());
		Assertions.assertEquals(17, names[0].marriageAge);
	}
}
