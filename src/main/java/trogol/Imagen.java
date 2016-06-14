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
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

/**
 * Aplicación Java Curso Java Uex Escuela de Ingenierías Industriales.
 *
 * @author Antonio Horrillo Horrillo
 * @version 2.0.0.0
 */
public class Imagen extends Figura {

	/**
	 * Atributos.
	 */
	private Image foto = null;

	/**
	 * Constructor (Solo necesita el archivo donde se encuentra la imagen).
	 * 
	 * @param archivoImagen
	 */
	Imagen(String archivoImagen) {
		super(0, 0, 0, 0);
		foto = new ImageIcon(getClass().getResource(archivoImagen)).getImage();
		super.setAlto(foto.getHeight(null));
		super.setAncho(foto.getWidth(null));
	}

	/**
	 * Método ColocarAleatorio(int panelanch, int panelalt).
	 * 
	 * Colcar la imagen en un lugar aleatorio: panelanch indica la anchura del
	 * panel donde se va a colocar la imagen. panelalt indica la altura del
	 * panel donde se va a colocar la imagen.
	 * 
	 * @param panelanch
	 * @param panelalt
	 */
	public void ColocarAleatorio(int panelanch, int panelalt) {
		int numCol, numFil, x, y;
		Random numero;

		numCol = panelanch / super.getAncho(); // calcula el número de columnas
		numFil = panelalt / super.getAlto(); // calcula el número de filas

		numero = new Random();
		x = numero.nextInt(numCol); // columna aleatoria
		y = numero.nextInt(numFil); // fila aleatoria

		super.setX(x * super.getAncho()); // coloca la imagen en la columna
											// aleatoria
		super.setY(y * super.getAlto()); // coloca la imagen en la fila
											// aleatoria
	}

	/**
	 * Método Mostrar(Graphics g)
	 * 
	 * Muestra la imagen en pantalla. g es el área gra´fica donde se va a
	 * mostrar la imagen.
	 */
	@Override
	public void Mostrar(Graphics g) {
		g.drawImage(foto, super.getX(), super.getY(), null);
	}
}