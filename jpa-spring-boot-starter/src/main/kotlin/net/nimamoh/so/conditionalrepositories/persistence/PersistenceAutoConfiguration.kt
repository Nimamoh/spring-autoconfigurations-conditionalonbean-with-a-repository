package net.nimamoh.so.conditionalrepositories.persistence

import net.nimamoh.so.conditionalrepositories.persistence.entities.EntityStub
import net.nimamoh.so.conditionalrepositories.persistence.repositories.FakeRepository
import org.springframework.boot.autoconfigure.AutoConfigureAfter
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import javax.persistence.EntityManagerFactory

@Configuration(proxyBeanMethods = false)
@ConditionalOnBean(EntityManagerFactory::class)
@AutoConfigureAfter(JpaRepositoriesAutoConfiguration::class)
@EnableJpaRepositories(basePackageClasses = [FakeRepository::class])
@EntityScan(basePackageClasses = [EntityStub::class])
class PersistenceAutoConfiguration