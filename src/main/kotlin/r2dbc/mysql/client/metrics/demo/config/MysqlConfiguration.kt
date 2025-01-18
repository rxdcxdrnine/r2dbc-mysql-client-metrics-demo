package r2dbc.mysql.client.metrics.demo.config

import io.asyncer.r2dbc.mysql.MySqlConnectionConfiguration
import io.asyncer.r2dbc.mysql.MySqlConnectionFactory
import io.r2dbc.spi.ConnectionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@Configuration
@EnableR2dbcRepositories
class MysqlConfiguration(
    private val container: MysqlTestContainer,
) : AbstractR2dbcConfiguration() {
    @Bean
    override fun connectionFactory(): ConnectionFactory = MySqlConnectionConfiguration
        .builder()
        .host(container.host)
        .port(container.port)
        .database("test")
        .user("test")
        .password("test")
        .createDatabaseIfNotExist(true)
        .build()
        .let(MySqlConnectionFactory::from)
}
