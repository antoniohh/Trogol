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
 * Aplicación Java Curso Java Uex Escuela de Ingenierías Industriales.
 *
 * @author Antonio Horrillo Horrillo
 * @version 2.0.0.0
 */
public class ImagenDinamica extends Imagen {

	/**
	 * Constructor de la clase ImagenDinamica.
	 * 
	 * @param archivoImagen
	 */
	ImagenDinamica(String archivoImagen) {
		super(archivoImagen);
	}

	/**
	 * Método Subir(int min).
	 * 
	 * @param min
	 */
	public void Subir(int min) {
		if (super.getY() > min)
			super.setY(super.getY() - super.getAlto());
	}

	/**
	 * Método Bajar(int max).
	 * 
	 * @param max
	 */
	public void Bajar(int max) {
		if (super.getY() + super.getAlto() < max)
			super.setY(super.getY() + super.getAlto());
	}

	/**
	 * Método Izquierda(int min).
	 * 
	 * @param min
	 */
	public void Izquierda(int min) {
		if (super.getX() > min)
			super.setX(super.getX() - super.getAncho());
	}

	/**
	 * Método Derecha(int max).
	 * 
	 * @param max
	 */
	public void Derecha(int max) {
		if (super.getX() + super.getAncho() < max)
			super.setX(super.getX() + super.getAncho());
	}
}