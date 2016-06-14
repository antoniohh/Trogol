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
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import org.apache.log4j.Logger;

/**
 * Aplicación Java Curso Java Uex Escuela de Ingenierías Industriales.
 *
 * @author Antonio Horrillo Horrillo
 * @version 2.0.0.0
 */
public class Sistema {

	/**
	 * Atributos.
	 */
	private String sistema;
	private String arquitectura;
	private String usuRuta;
	private String javaRuta;
	private String sepRuta;
	private String dbRuta;
	private File tempFile;
	private String actRuta;
	private String dbFile;
	private String sndFile;
	private static final Logger LOG = Logger.getLogger(Sistema.class);

	/**
	 * Constructor de clase que inicializa los atributos a los valores del
	 * sistema.
	 */
	public Sistema() {
		this.sistema = System.getProperty("os.name");
		this.arquitectura = System.getProperty("os.arch");
		this.usuRuta = System.getProperty("user.dir");
		this.javaRuta = System.getProperty("java.home");
		this.sepRuta = System.getProperty("file.separator");
		this.tempFile = new File(".");
		this.actRuta = tempFile.getAbsolutePath();
		this.dbRuta = this.actRuta + this.sepRuta + "db";
		this.dbFile = this.actRuta + this.sepRuta + "db" + this.sepRuta + "trogol.db";
		this.sndFile = this.actRuta + this.sepRuta + "snd" + this.sepRuta;
	}

	/**
	 * Constructor de clase que inicializa los atributos a los valores indicados
	 * por los parámetros.
	 * 
	 * @param sistema
	 * @param arquitectura
	 * @param usuRuta
	 * @param javaRuta
	 * @param sepRuta
	 * @param dbRuta
	 * @param actRuta
	 * @param tempFile
	 * @param dbFile
	 * @param sndFile
	 */
	public Sistema(String sistema, String arquitectura, String usuRuta, String javaRuta, String sepRuta, String dbRuta,
			String actRuta, File tempFile, String dbFile, String sndFile) {
		this.sistema = sistema;
		this.arquitectura = arquitectura;
		this.usuRuta = usuRuta;
		this.javaRuta = javaRuta;
		this.sepRuta = sepRuta;
		this.dbRuta = dbRuta;
		this.tempFile = tempFile;
		this.actRuta = actRuta;
		this.dbFile = dbFile;
		this.sndFile = sndFile;
	}

	/**
	 * Método activarSonido(String fichero).
	 * 
	 * Activamos los sonidos del juego.
	 * 
	 * @param fichero
	 */
	public void activarSonido(String fichero) {
		try {
			Clip sonido = AudioSystem.getClip();
			File audio = new File(fichero);
			sonido.open(AudioSystem.getAudioInputStream(audio));
			// sonido.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(fichero)));
			sonido.start();
			// Thread.sleep(1000); // 1000 milisegundos (10 segundos)
			// sonido.close();
		} catch (Exception ex) {
			System.err.println("No ha sido posible reproducir el sonido: " + ex);
			LOG.fatal("No ha sido posible reproducir el sonido: ", ex);
		}
	}

	/**
	 * Metodo get para obtener (leer) el atributo.
	 * 
	 * @return
	 */
	public String getSndFile() {
		return sndFile;
	}

	/**
	 * Metodo set para asignar (almacenar) el atributo.
	 * 
	 * @param sndFile
	 */
	public void setSndFile(String sndFile) {
		this.sndFile = sndFile;
	}

	/**
	 * Metodo get para obtener (leer) el atributo.
	 * 
	 * @return
	 */
	public String getDbFile() {
		return dbFile;
	}

	/**
	 * Metodo set para asignar (almacenar) el atributo.
	 * 
	 * @param dbFile
	 */
	public void setDbFile(String dbFile) {
		this.dbFile = dbFile;
	}

	/**
	 * Metodo get para obtener (leer) el atributo.
	 * 
	 * @return
	 */
	public File getTempFile() {
		return tempFile;
	}

	/**
	 * Metodo set para asignar (almacenar) el atributo.
	 * 
	 * @param tempFile
	 */
	public void setTempFile(File tempFile) {
		this.tempFile = tempFile;
	}

	/**
	 * Metodo get para obtener (leer) el atributo.
	 * 
	 * @return
	 */
	public String getActRuta() {
		return actRuta;
	}

	/**
	 * Metodo set para asignar (almacenar) el atributo.
	 * 
	 * @param actRuta
	 */
	public void setActRuta(String actRuta) {
		this.actRuta = actRuta;
	}

	/**
	 * Metodo get para obtener (leer) el atributo.
	 * 
	 * @return
	 */
	public String getSistema() {
		return sistema;
	}

	/**
	 * Metodo set para asignar (almacenar) el atributo.
	 * 
	 * @param sistema
	 */
	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	/**
	 * Metodo get para obtener (leer) el atributo.
	 * 
	 * @return
	 */
	public String getArquitectura() {
		return arquitectura;
	}

	/**
	 * Metodo set para asignar (almacenar) el atributo.
	 * 
	 * @param arquitectura
	 */
	public void setArquitectura(String arquitectura) {
		this.arquitectura = arquitectura;
	}

	/**
	 * Metodo get para obtener (leer) el atributo.
	 * 
	 * @return
	 */
	public String getUsuRuta() {
		return usuRuta;
	}

	/**
	 * Metodo set para asignar (almacenar) el atributo.
	 * 
	 * @param usuRuta
	 */
	public void setUsuRuta(String usuRuta) {
		this.usuRuta = usuRuta;
	}

	/**
	 * Metodo get para obtener (leer) el atributo.
	 * 
	 * @return
	 */
	public String getJavaRuta() {
		return javaRuta;
	}

	/**
	 * Metodo set para asignar (almacenar) el atributo.
	 * 
	 * @param javaRuta
	 */
	public void setJavaRuta(String javaRuta) {
		this.javaRuta = javaRuta;
	}

	/**
	 * Metodo get para obtener (leer) el atributo.
	 * 
	 * @return
	 */
	public String getSepRuta() {
		return sepRuta;
	}

	/**
	 * Metodo set para asignar (almacenar) el atributo.
	 * 
	 * @param sepRuta
	 */
	public void setSepRuta(String sepRuta) {
		this.sepRuta = sepRuta;
	}

	/**
	 * Metodo get para obtener (leer) el atributo.
	 * 
	 * @return
	 */
	public String getDbRuta() {
		return dbRuta;
	}

	/**
	 * Metodo set para asignar (almacenar) el atributo.
	 * 
	 * @param dbRuta
	 */
	public void setDbRuta(String dbRuta) {
		this.dbRuta = dbRuta;
	}

	/**
	 * Retorna el tipo de Sistema Operativo y la Arquitectura del mismo.
	 * 
	 * @return
	 */
	public String sistemaOperativo() {
		return this.sistema + " " + this.arquitectura;
	}

	/**
	 * Retorna la ruta de Java.
	 * 
	 * @return
	 */
	public String javaHome() {
		return this.javaRuta;
	}
}