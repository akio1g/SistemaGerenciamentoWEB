package com.fateczl.SistemaGerenciamentoWEB.persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

@Repository
public class GenericDAO {
	private Connection c;

	public Connection getConnection() throws ClassNotFoundException, SQLException {

		String hostName = "127.0.0.1";
		String dbName = "SistemaGerenciamentoWEB";
		String user = "sa";
		String senha = "Hungria123";
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		String connect = String.format(
				"jdbc:jtds:sqlserver://%s:1433;databaseName=%s;namedPipes=true;user=%s;password=%s", hostName, dbName,
				user, senha);
		c = DriverManager.getConnection(connect);

		return c;
	}
}
