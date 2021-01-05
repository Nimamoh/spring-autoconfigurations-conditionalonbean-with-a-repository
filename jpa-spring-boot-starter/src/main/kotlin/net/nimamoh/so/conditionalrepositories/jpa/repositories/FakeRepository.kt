package net.nimamoh.so.conditionalrepositories.jpa.repositories

import net.nimamoh.so.conditionalrepositories.domain.ports.driven.AwesomeRepository
import net.nimamoh.so.conditionalrepositories.jpa.entities.JpaStub
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.context.annotation.Primary
import org.springframework.data.repository.Repository

internal interface AwesomeRepositoryBySpringData: AwesomeRepository
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
        fakeRepository.save(JpaStub(identifier))
    }
}

@Primary
@org.springframework.stereotype.Repository
internal interface FakeRepository: Repository<JpaStub, String>, AwesomeRepositoryBySpringData {

    fun findAll(): Iterable<JpaStub>

    fun save(entity: JpaStub): JpaStub

    fun count(): Long
}

internal class FakeRepositoryImpl