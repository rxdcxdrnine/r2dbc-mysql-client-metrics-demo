package r2dbc.mysql.client.metrics.demo.service

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table
data class Person(
    @Id
    val id: Long?,
    val uuid: String,
)
