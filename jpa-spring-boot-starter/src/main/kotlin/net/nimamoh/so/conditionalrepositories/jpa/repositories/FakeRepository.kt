package net.nimamoh.so.conditionalrepositories.jpa.repositories

import net.nimamoh.so.conditionalrepositories.jpa.entities.JpaStub
import net.nimamoh.so.conditionalrepositories.jpa.repositories.AwesomeRepo
import org.springframework.data.repository.Repository

@org.springframework.stereotype.Repository
internal interface FakeRepository: Repository<JpaStub, String>, AwesomeRepo {
    fun count(): Long
}
