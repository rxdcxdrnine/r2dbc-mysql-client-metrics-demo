package r2dbc.mysql.client.metrics.demo.config

import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import org.testcontainers.containers.ContainerState
import org.testcontainers.containers.MySQLContainer
import org.testcontainers.utility.DockerImageName

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
class MysqlTestContainer(
    val container: ContainerState =
        MySQLContainer(DockerImageName.parse(IMAGE_NAME))
            .apply {
                withInitScripts("init.sql")
                start()
            },
) : ContainerState by container {
    companion object {
        private const val IMAGE_NAME = "mysql:8"
    }

    val port: Int
        get() = getMappedPort(MySQLContainer.MYSQL_PORT)
}
