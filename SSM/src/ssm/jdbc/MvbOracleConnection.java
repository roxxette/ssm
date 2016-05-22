package ssm.jdbc;

// File: MvbOracleConnection.java

import java.sql.*;

/*
 * This class is a singleton class that provides methods 
 * to connect to an Oracle database, return the connection, 
 * set the connection, and determine whether or not the Oracle
 * JDBC driver has been loaded. To obtain a reference to an
 * instance of this class, use the getInstance() method.
 */
public class MvbOracleConnection {
	private static MvbOracleConnection _mvb = null;
	protected Connection con = null;
	protected Connection con0 = null;
	protected boolean driverLoaded = false;

	/*
	 * The constructor is declared protected so that only subclasses can access
	 * it.
	 */
	protected MvbOracleConnection() {
		// empty
	}

	/*
	 * Returns an instance of MvbOracleConnection
	 */
	public static MvbOracleConnection getInstance() {
		if (_mvb == null) {
			_mvb = new MvbOracleConnection();
		}

		return _mvb;
	}

	/*
	 * Loads the Oracle JDBC driver and connects to the database named ug using
	 * the given username and password. Returns true if the connection is
	 * successful; false otherwise.
	 */
	public boolean connect(String username, String password) {
		try {
			// change the url if the branch table is located somewhere else
			String url = "jdbc:oracle:thin:@129.184.13.100:1521:bank";
			url = "jdbc:mysql://localhost:3306/ssm";

			if (!driverLoaded) {
//				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
//				driverLoaded = true;
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				driverLoaded = true;
				
			}

			con = DriverManager.getConnection(url, username, password);
			con.setAutoCommit(false);

			con0 = DriverManager.getConnection(url, username, password);
			con0.setAutoCommit(false);

			return true;
		} catch (SQLException ex) {
			return false;
		}
	}

	/*
	 * Returns the connection
	 */
	public Connection getConnection() {
		return con;
	}

	public Connection getConnection0() {
		return con0;
	}

	/*
	 * Returns true if the driver is loaded; false otherwise
	 */
	public boolean isDriverLoaded() {
		return driverLoaded;
	}

	/*
	 * This method allows members of this class to clean up after itself before
	 * it is garbage collected. It is called by the garbage collector.
	 */
	protected void finalize() throws Throwable {
		if (con != null) {
			con.close();
		}

		// finalize() must call super.finalize() as the last thing it does
		super.finalize();
	}
}