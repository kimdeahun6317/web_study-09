package web_study_09.ds;

import java.sql.Connection;

import org.junit.Test;

public class JdbcUtilJNDITest {

	@Test
	public void testGetConnection() {
		Connection con = JdbcUtilJNDI.getConnection();
	}

}
