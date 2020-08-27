package web_study_09.ds;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
	public static Connection getConnection() {
		Connection con = null;
		String proptiesPath = "Db.properties";
		try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(proptiesPath)) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Properties props = new Properties();
			props.load(is);

			String url = props.getProperty("url");

			con = DriverManager.getConnection(url, props);
			System.out.println(con);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
}
