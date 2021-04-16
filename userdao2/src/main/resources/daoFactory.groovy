import kr.ac.jejunu.UserDao
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.SimpleDriverDataSource

beans {
    dataSource(SimpleDriverDataSource) {
        driverClass = System.getenv("DB_DRIVER")
        url = System.getenv("DB_URL")
        username = System.getenv("DB_USERNAME")
        password = System.getenv("DB_PASSWORD")
    }
    jdbcTemplate(JdbcTemplate, dataSource) {

    }
    userDao(UserDao, jdbcTemplate) {

    }
}