package net.nimamoh.so.conditionalrepositories.jpa.entities

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class JpaStub(
    @Id val name: String
) { }