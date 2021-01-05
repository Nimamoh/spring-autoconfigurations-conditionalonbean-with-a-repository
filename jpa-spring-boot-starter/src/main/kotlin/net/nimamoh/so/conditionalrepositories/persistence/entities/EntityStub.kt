package net.nimamoh.so.conditionalrepositories.persistence.entities

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class EntityStub(
    @Id val identifier: String
)