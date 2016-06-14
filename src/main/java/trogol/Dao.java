/*
 * Copyright (C) 2016 Antonio Horrillo Horrillo
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * Paquete trogol.
 */
package trogol;

/**
 * Importamos las librerías necesarias.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Aplicación Java Curso Java Uex Escuela de Ingenierías Industriales.
 *
 * @author Antonio Horrillo Horrillo
 * @version 2.0.0.0
 */
public class Dao extends Sistema {

	/**
	 * Atributos.
	 */
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private ArrayList<Object> lista;
	private Boolean existe;

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public Statement getStmt() {
		return stmt;
	}

	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public ArrayList<Object> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Object> lista) {
		this.lista = lista;
	}

	public Boolean getExiste() {
		return existe;
	}

	public void setExiste(Boolean existe) {
		this.existe = existe;
	}

	/**
	 * Método Constructor Dao().
	 * 
	 * Accedemos a las propiedades de la clase padre.
	 */
	public Dao() {
		super();
	}

	/**
	 * Método crearDB().
	 * 
	 * Creamos la base de datos.
	 */
	public void crearDB() {
		try {
			Class.forName("org.sqlite.JDBC");
			this.conn = DriverManager.getConnection("jdbc:sqlite:" + this.getDbFile());
			this.stmt = this.conn.createStatement();
			this.stmt.close();
			this.conn.close();
			System.out.println("Base de Datos creada correctamente.");
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.out.println("No se ha podido crear la base de datos.");
		}
	}

	/**
	 * Método crearTabla()
	 * 
	 * Crea la tabla "USUARIOS" si no existe.
	 */
	public void crearTabla() {
		try {
			Class.forName("org.sqlite.JDBC");
			this.conn = DriverManager.getConnection("jdbc:sqlite:" + this.getDbFile());
			this.stmt = this.conn.createStatement();
			System.out.println("Conexión a la base de Datos realizada correctamente.");
			String sql = "CREATE TABLE IF NOT EXISTS USUARIOS " + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ " USUARIO TEXT NOT NULL," + " CONTRASEÑA TEXT NOT NULL)";
			this.stmt.executeUpdate(sql);
			this.stmt.close();
			this.conn.close();
			System.out.println("Tabla creada correctamente.");
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.out.println("No se ha podido crear la tabla.");
		}
	}

	/**
	 * Método insertarUsuario(String usuario, String contraseña).
	 * 
	 * @param usuario,
	 *            contraseña
	 */
	public void insertarUsuario(String usuario, String contraseña) {
		try {
			Class.forName("org.sqlite.JDBC");
			this.conn = DriverManager.getConnection("jdbc:sqlite:" + this.getDbFile());
			System.out.println("Conexión a la base de Datos realizada correctamente.");
			this.conn.setAutoCommit(false);
			this.stmt = this.conn.createStatement();
			String sql = "INSERT INTO USUARIOS (USUARIO,CONTRASEÑA) VALUES ('" + usuario + "','" + contraseña + "');";
			this.stmt.executeUpdate(sql);
			this.stmt.close();
			this.conn.commit();
			this.conn.close();
			System.out.println("Datos insertados en la tabla correctamente.");
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.out.println("No se ha podido insertar los datos en la tabla.");
		}
	}

	/**
	 * Método eliminarUsuario(String usuario, String contraseña).
	 * 
	 * @param usuario,
	 *            contraseña
	 */
	public void eliminarUsuario(String usuario, String contraseña) {
		try {
			Class.forName("org.sqlite.JDBC");
			this.conn = DriverManager.getConnection("jdbc:sqlite:" + this.getDbFile());
			System.out.println("Conexión a la base de Datos realizada correctamente.");
			this.conn.setAutoCommit(false);
			this.stmt = this.conn.createStatement();
			String sql = "DELETE FROM USUARIOS WHERE CONTRASEÑA = '" + contraseña + "' AND USUARIO = '" + usuario
					+ "';";
			this.stmt.executeUpdate(sql);
			this.stmt.close();
			this.conn.commit();
			this.conn.close();
			System.out.println("Datos eliminados de la tabla correctamente.");
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.out.println("No se ha podido eliminar los datos de la tabla.");
		}
	}

	/**
	 * Método comprobarUsuario(String usuario).
	 * 
	 * @param usuario,
	 *            contraseña
	 * @return
	 */
	public Boolean comprobarUsuario(String usuario, String contraseña) {
		try {
			Class.forName("org.sqlite.JDBC");
			this.conn = DriverManager.getConnection("jdbc:sqlite:" + this.getDbFile());
			System.out.println("Conexión a la base de Datos realizada correctamente.");
			this.conn.setAutoCommit(false);
			this.stmt = this.conn.createStatement();
			this.rs = this.stmt.executeQuery(
					"SELECT * FROM USUARIOS WHERE CONTRASEÑA = '" + contraseña + "' AND USUARIO = '" + usuario + "';");
			this.existe = this.rs.next();
			this.rs.close();
			this.stmt.close();
			this.conn.close();
			System.out.println("Datos leidos de la tabla correctamente.");
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.out.println("No se ha podido insertar los datos en la tabla.");
		}
		return existe;
	}

	/**
	 * Método leerUsuarios().
	 * 
	 * @return
	 */
	public ArrayList<Object> leerUsuarios() {
		try {
			Class.forName("org.sqlite.JDBC");
			this.conn = DriverManager.getConnection("jdbc:sqlite:" + this.getDbFile());
			System.out.println("Conexión a la base de Datos realizada correctamente.");
			this.conn.setAutoCommit(false);
			this.stmt = this.conn.createStatement();
			this.rs = this.stmt.executeQuery("SELECT * FROM USUARIOS;");
			// this.columnas = this.rs.getMetaData().getColumnCount();
			this.lista = new ArrayList<>();
			while (this.rs.next()) {
				// this.fila = new ArrayList<>(this.columnas);
				// for (int i=1; i<= this.columnas; i++) {
				// this.fila.add(this.rs.getString(i));
				// }
				// this.lista.add(this.fila);
				this.lista.add(this.rs.getString("USUARIO"));
			}
			this.rs.close();
			this.stmt.close();
			this.conn.close();
			System.out.println("Datos leidos de la tabla correctamente.");
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.out.println("No se ha podido leer los datos de la tabla.");
		}
		return this.lista;
	}
}