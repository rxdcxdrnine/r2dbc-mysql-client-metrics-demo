# r2dbc-mysql-client-metrics-demo

add reactor-netty TcpClient metrics for r2dbc-mysql

```sh
# start application
./gradlew bootRun

# grep reactor_netty
curl -s -XGET "http://localhost:8080/actuator/prometheus" | grep -E '(^reactor_netty_eventloop.*|^reactor_netty_tcp.*)'
```

### result

```text
reactor_netty_eventloop_pending_tasks{name="reactor-tcp-nio-4"} 0.0
reactor_netty_eventloop_pending_tasks{name="reactor-tcp-nio-5"} 0.0
reactor_netty_eventloop_pending_tasks{name="reactor-tcp-nio-6"} 0.0
reactor_netty_eventloop_pending_tasks{name="reactor-tcp-nio-7"} 0.0
reactor_netty_eventloop_pending_tasks{name="reactor-tcp-nio-8"} 0.0
reactor_netty_tcp_client_address_resolver_seconds_count{remote_address="localhost:64921",status="SUCCESS"} 100
reactor_netty_tcp_client_address_resolver_seconds_sum{remote_address="localhost:64921",status="SUCCESS"} 1.095592293
reactor_netty_tcp_client_address_resolver_seconds_max{remote_address="localhost:64921",status="SUCCESS"} 0.01396475
reactor_netty_tcp_client_connect_time_seconds_count{proxy_address="na",remote_address="localhost:64921",status="SUCCESS"} 100
reactor_netty_tcp_client_connect_time_seconds_sum{proxy_address="na",remote_address="localhost:64921",status="SUCCESS"} 3.49526084
reactor_netty_tcp_client_connect_time_seconds_max{proxy_address="na",remote_address="localhost:64921",status="SUCCESS"} 0.039677708
reactor_netty_tcp_client_data_received_bytes_count{proxy_address="na",remote_address="localhost:64921",uri="tcp"} 814
reactor_netty_tcp_client_data_received_bytes_sum{proxy_address="na",remote_address="localhost:64921",uri="tcp"} 325900.0
reactor_netty_tcp_client_data_received_bytes_max{proxy_address="na",remote_address="localhost:64921",uri="tcp"} 2048.0
reactor_netty_tcp_client_data_sent_bytes_count{proxy_address="na",remote_address="localhost:64921",uri="tcp"} 1200
reactor_netty_tcp_client_data_sent_bytes_sum{proxy_address="na",remote_address="localhost:64921",uri="tcp"} 108700.0
```