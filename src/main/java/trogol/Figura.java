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
import java.awt.Color;
import java.awt.Graphics;

/**
 * Aplicación Java Curso Java Uex Escuela de Ingenierías Industriales.
 *
 * @author Antonio Horrillo Horrillo
 * @version 2.0.0.0
 */
public class Figura {

	/**
	 * Atributos.
	 */
	private int x; // Coordenada X
	private int y; // Coordenada Y
	private int alto; // Altura
	private int ancho; // Anchura

	/**
	 * Constructor de la clase Figura.
	 * 
	 * @param x
	 * @param y
	 * @param alto
	 * @param ancho
	 */
	Figura(int x, int y, int alto, int ancho) {
		this.x = x;
		this.y = y;
		this.alto = alto;
		this.ancho = ancho;
	}

	/**
	 * Métodos Get and Set.
	 */
	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return y;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getAlto() {
		return alto;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAncho() {
		return ancho;
	}

	/**
	 * Método Mostrar(Graphics g).
	 * 
	 * Mostramos la imagen.
	 * 
	 * @param g
	 */
	public void Mostrar(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(x, y, ancho, alto);
	}

	/**
	 * Método Ocultar(Graphics g).
	 * 
	 * Ocultamos la imagen.
	 * 
	 * @param g
	 */
	public void Ocultar(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, ancho, alto);
	}

}
