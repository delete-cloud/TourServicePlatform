package me.kinaz.tourserviceplatform.conf;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.jms.JMSDestinationDefinition;

@Singleton
@Startup
@DataSourceDefinition(
        name = "java:/MySqlDS",
        className = "com.mysql.cj.jdbc.MysqlDataSource",
        url = "your_mysql_url",
        user="your_mysql_user",
        password="your_mysql_password"
)
@JMSDestinationDefinition(
        name = "java:/jms/queue/TicketQueue",
        interfaceName = "jakarta.jms.Queue",
        destinationName = "TicketQueue"
)
public class AppConfig {
}
