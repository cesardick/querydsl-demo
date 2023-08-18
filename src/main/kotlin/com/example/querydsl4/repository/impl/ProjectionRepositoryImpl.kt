package ampli.commons.jpa.repository

import com.querydsl.core.types.FactoryExpression
import com.querydsl.core.types.OrderSpecifier
import com.querydsl.core.types.Predicate
import com.querydsl.core.types.dsl.PathBuilder
import com.querydsl.core.types.dsl.SimpleExpression
import jakarta.persistence.EntityManager
import org.springframework.data.domain.*
import org.springframework.data.jpa.repository.support.JpaEntityInformation
import org.springframework.data.jpa.repository.support.Querydsl
import org.springframework.data.jpa.repository.support.QuerydslJpaPredicateExecutor
import org.springframework.data.querydsl.EntityPathResolver
import org.springframework.data.querydsl.QSort
import org.springframework.data.querydsl.SimpleEntityPathResolver
import java.util.*

class ProjectionRepositoryImpl<TI, ID>(
    entityInformation: JpaEntityInformation<TI, *>,
    private val entityManager: EntityManager
) :
    QuerydslJpaPredicateExecutor<TI>(entityInformation, entityManager, resolver, null),
    ProjectionRepository<TI, ID> {

    private val querydsl: Querydsl
    private val clazz: Class<TI>

    init {
        val path = resolver.createPath(entityInformation.javaType)
        val builder = PathBuilder(path.type, path.metadata)
        this.querydsl = Querydsl(entityManager, builder)
        this.clazz = entityInformation.javaType
    }

    override fun <PROJ> findOne(factoryExpression: FactoryExpression<PROJ>, predicate: Predicate): Optional<PROJ> {
        return Optional.ofNullable(createQuery(predicate).select(factoryExpression).fetchFirst())
    }

    override fun <PROJ> findAll(factoryExpression: FactoryExpression<PROJ>): List<PROJ> {
        return createQuery().select(factoryExpression).fetch()
    }

    override fun <PROJ> findAll(factoryExpression: FactoryExpression<PROJ>, sort: Sort): List<PROJ> {
        return querydsl.applySorting(sort, createQuery().select(factoryExpression)).fetch()
    }

    override fun <PROJ> findAll(
        factoryExpression: FactoryExpression<PROJ>,
        vararg orders: OrderSpecifier<*>
    ): List<PROJ> {
        return findAll(factoryExpression, QSort(*orders))
    }

    override fun <PROJ> findAll(factoryExpression: FactoryExpression<PROJ>, predicate: Predicate): List<PROJ> {
        return createQuery(predicate).select(factoryExpression).fetch()
    }

    override fun <PROJ> findAll(
        factoryExpression: FactoryExpression<PROJ>,
        predicate: Predicate,
        sort: Sort
    ): List<PROJ> {
        return querydsl.applySorting(sort, createQuery(predicate).select(factoryExpression)).fetch()
    }

    override fun <PROJ> findAll(
        factoryExpression: FactoryExpression<PROJ>,
        predicate: Predicate,
        vararg orders: OrderSpecifier<*>
    ): List<PROJ> {
        return findAll(factoryExpression, predicate, QSort(*orders))
    }

    override fun <PROJ> findAll(
        factoryExpression: FactoryExpression<PROJ>,
        predicate: Predicate,
        pageable: Pageable
    ): Page<PROJ> {
        val query = querydsl.applyPagination(
            pageable, createQuery(predicate).select(
                factoryExpression
            )
        )
        val total = createQuery(predicate).fetchCount()
        val content = if (total > pageable.offset) query.fetch() else emptyList()
        return PageImpl(content, pageable, total)
    }

    override fun <PROJ> findAll(
        factoryExpression: FactoryExpression<PROJ>,
        predicate: Predicate,
        offset: Long,
        size: Long,
        sort: Sort
    ): Page<PROJ> {
        val query = createQuery(predicate).select(factoryExpression)
        query.offset(offset)
        query.limit(size)
        querydsl.applySorting(sort, query)
        val total = createQuery(predicate).fetchCount()
        val content = if (total > offset) query.fetch() else emptyList()
        var page = (offset / size).toInt()
        if (offset % size > 0) {
            page++
        }

        return PageImpl(content, PageRequest.of(page, size.toInt(), sort), total)
    }

    override fun <PROJ> findAllDistinct(factoryExpression: FactoryExpression<PROJ>, predicate: Predicate): List<PROJ> {
        return createQuery(predicate).distinct().select(factoryExpression).fetch()
    }

    companion object {
        private val resolver: EntityPathResolver = SimpleEntityPathResolver.INSTANCE
    }
}
