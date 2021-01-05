package net.nimamoh.so.conditionalrepositories.api.services

import net.nimamoh.so.conditionalrepositories.domain.ports.driven.AwesomeRepository

interface ApiServices {
    fun loadSomeStubData()
    fun listStubIdentifiers(): Collection<String>
}

class ApiServicesImpl(private val awesomeRepository: AwesomeRepository): ApiServices {

    override fun loadSomeStubData() {
        awesomeRepository.saveWithIdentifier("Hello")
        awesomeRepository.saveWithIdentifier("World")
        awesomeRepository.saveWithIdentifier("from")
        awesomeRepository.saveWithIdentifier("ApiServicesImpl")
    }

    override fun listStubIdentifiers(): Collection<String> {
        return awesomeRepository.listIdentifiers()
    }
}