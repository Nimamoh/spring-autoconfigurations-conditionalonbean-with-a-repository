package net.nimamoh.so.conditionalrepositories.api

import net.nimamoh.so.conditionalrepositories.api.controllers.RestEndpoints
import net.nimamoh.so.conditionalrepositories.api.services.ApiServices
import net.nimamoh.so.conditionalrepositories.api.services.ApiServicesImpl
import net.nimamoh.so.conditionalrepositories.domain.ports.driven.AwesomeRepository
import net.nimamoh.so.conditionalrepositories.persistence.PersistenceAutoConfiguration
import org.springframework.boot.autoconfigure.AutoConfigureAfter
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration(proxyBeanMethods = false)
@AutoConfigureAfter(PersistenceAutoConfiguration::class)
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.ANY)
@ComponentScan(basePackageClasses = [RestEndpoints::class])
class ApiAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    /*
     XXX: This is the line causing the issue.
     see https://stackoverflow.com/questions/36978302/spring-jpa-repositories-postconstruct
     comment to make it work...
     */
    @ConditionalOnBean(AwesomeRepository::class)
    fun apiService(awesomeRepository: AwesomeRepository): ApiServices {
        return ApiServicesImpl(awesomeRepository)
    }
}