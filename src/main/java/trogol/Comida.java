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
import java.util.Random;

/**
 * Aplicación Java Curso Java Uex Escuela de Ingenierías Industriales.
 *
 * @author Antonio Horrillo Horrillo
 * @version 2.0.0.0
 * 
 */
public class Comida extends Imagen {

	/**
	 * Atributos.
	 */
	private int energia;

	/**
	 * Constructor de la clase Comida.
	 * 
	 * @param archivoImagen
	 */
	Comida(String archivoImagen) {
		super(archivoImagen);
		// TODO Auto-generated constructor stub
		energizar();
	}

	public void energizar() {
		Random numero = new Random();
		energia = numero.nextInt(10) + 1;

	}

	/**
	 * @return the energía
	 */
	public int getEnergia() {
		return energia;
	}

	/**
	 * @param energia
	 *            the energía to set
	 */
	public void setEnergia(int energia) {
		this.energia = energia;

	}

}
