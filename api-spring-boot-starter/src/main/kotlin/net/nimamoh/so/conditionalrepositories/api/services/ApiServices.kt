package net.nimamoh.so.conditionalrepositories.api.services

import net.nimamoh.so.conditionalrepositories.domain.ports.driven.AwesomeRepository

class ApiServices(private val awesomeRepository: AwesomeRepository) {

    fun loadSomeStubData() {
        awesomeRepository.saveWithIdentifier("Hello")
        awesomeRepository.saveWithIdentifier("World")
    }

    fun listStubIdentifiers(): Collection<String> {
        return awesomeRepository.listIdentifiers()
    }
}