package ampli.commons.jpa.repository

import com.querydsl.core.types.FactoryExpression
import com.querydsl.core.types.OrderSpecifier
import com.querydsl.core.types.Predicate
import com.querydsl.core.types.dsl.SimpleExpression
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.data.repository.Repository
import java.util.*

@NoRepositoryBean
interface ProjectionRepository<T, TID> : Repository<T, TID> {
    fun <PROJ> findOne(factoryExpression: FactoryExpression<PROJ>, predicate: Predicate): Optional<PROJ>
    fun <PROJ> findAll(factoryExpression: FactoryExpression<PROJ>): List<PROJ>
    fun <PROJ> findAll(factoryExpression: FactoryExpression<PROJ>, sort: Sort): List<PROJ>
    fun <PROJ> findAll(factoryExpression: FactoryExpression<PROJ>, vararg orders: OrderSpecifier<*>): List<PROJ>
    fun <PROJ> findAll(factoryExpression: FactoryExpression<PROJ>, predicate: Predicate): List<PROJ>
    fun <PROJ> findAll(factoryExpression: FactoryExpression<PROJ>, predicate: Predicate, sort: Sort): List<PROJ>
    fun <PROJ> findAll(
        factoryExpression: FactoryExpression<PROJ>,
        predicate: Predicate,
        vararg orders: OrderSpecifier<*>
    ): List<PROJ>

    fun <PROJ> findAll(factoryExpression: FactoryExpression<PROJ>, predicate: Predicate, pageable: Pageable): Page<PROJ>
    fun <PROJ> findAll(
        factoryExpression: FactoryExpression<PROJ>,
        predicate: Predicate,
        offset: Long,
        size: Long,
        sort: Sort
    ): Page<PROJ>
    fun <PROJ> findAllDistinct(factoryExpression: FactoryExpression<PROJ>, predicate: Predicate): List<PROJ>
}
