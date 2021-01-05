package net.nimamoh.so.conditionalrepositories.domain.ports.driven

interface AwesomeRepository {
    fun listIdentifiers(): Collection<String>
    fun saveWithIdentifier(identifier: String)
}