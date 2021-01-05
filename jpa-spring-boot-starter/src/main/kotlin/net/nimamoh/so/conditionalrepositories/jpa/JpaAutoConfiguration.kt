package net.nimamoh.so.conditionalrepositories.jpa

import net.nimamoh.so.conditionalrepositories.domain.ports.driven.AwesomeRepository
import net.nimamoh.so.conditionalrepositories.jpa.entities.JpaStub
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
@EnableJpaRepositories(basePackageClasses = [AwesomeRepository::class])
@EntityScan(basePackageClasses = [JpaStub::class])
class JpaAutoConfiguration