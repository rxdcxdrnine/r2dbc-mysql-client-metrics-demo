package r2dbc.mysql.client.metrics.demo.service

 import org.springframework.data.repository.reactive.ReactiveCrudRepository

 interface PersonRepository : ReactiveCrudRepository<Person, Long>
