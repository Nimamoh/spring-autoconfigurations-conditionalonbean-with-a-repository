package net.nimamoh.so.conditionalrepositories.persistence.repositories

import net.nimamoh.so.conditionalrepositories.domain.ports.driven.AwesomeRepository
import net.nimamoh.so.conditionalrepositories.persistence.entities.EntityStub
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.context.annotation.Primary
import org.springframework.data.repository.Repository

internal interface AwesomeRepositoryBySpringData: AwesomeRepository
@Suppress("unused")
internal class AwesomeRepositoryBySpringDataImpl(
    @Lazy
    @Autowired
    private val fakeRepository: FakeRepository
): AwesomeRepositoryBySpringData {

    override fun listIdentifiers(): Collection<String> {
        val stubs = fakeRepository.findAll()
        return stubs.map { it.identifier }
    }

    override fun saveWithIdentifier(identifier: String) {
        fakeRepository.save(EntityStub(identifier))
    }
}

@Primary
@org.springframework.stereotype.Repository
internal interface FakeRepository: Repository<EntityStub, String>, AwesomeRepositoryBySpringData {

    fun findAll(): Iterable<EntityStub>

    fun save(entity: EntityStub): EntityStub

    fun count(): Long
}