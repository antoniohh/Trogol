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
import java.util.Random;
import javax.swing.JSpinner;

/**
 * Aplicación Java Curso Java Uex Escuela de Ingenierías Industriales.
 *
 * @author Antonio Horrillo Horrillo
 * @version 2.0.0.0
 * 
 */
public class Fantasma extends ImagenDinamica implements Runnable {

	/**
	 * Atributos.
	 */
	private Thread Hilo = null;
	private Graphics area = null;
	private int ancho;
	private int alto;
	private int espera;
	private JSpinner campoEnergia;
	private int i;
	private int maxhamburguesas;
	private ImagenDinamica trogol;
	private Comida[] hamburguesa;
	private final Sistema SISTEMA = new Sistema();

	/**
	 * Constructor de la clase Fantasma.
	 * 
	 * @param archivoImagen
	 * @param ancho
	 * @param alto
	 * @param area
	 * @param espera
	 * @param trogol
	 * @param hamburguesa
	 * @param maxhamburguesas
	 * @param campoEnergia
	 */
	public Fantasma(String archivoImagen, int ancho, int alto, Graphics area, int espera, ImagenDinamica trogol,
			Comida[] hamburguesa, int maxhamburguesas, JSpinner campoEnergia) {
		super(archivoImagen);
		this.ancho = ancho;
		this.alto = alto;
		this.area = area;
		this.espera = espera;
		this.trogol = trogol;
		this.hamburguesa = hamburguesa;
		this.maxhamburguesas = maxhamburguesas;
		this.campoEnergia = campoEnergia;

		if (Hilo == null) {
			Hilo = new Thread(this);
			Hilo.start();

		}
	}

	/**
	 * Launch the Thread.
	 */
	public void run() {
		while ((int) campoEnergia.getValue() > 0) {
			Mover();
			try {
				Thread.sleep(espera);
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
	}

	/**
	 * Método Mover().
	 * 
	 * Controlamos el movimiento aleatorio de cada fantasma lanzado en un
	 * thread. EL fantasma puede moverse a la izquierda, derecha, subir y bajar,
	 * siendo esta elección aleatoria. En cada movimiento se comprueba la nueva
	 * posición con la existencia de una hamburguesa o el trogol.
	 */
	private void Mover() {
		int x;
		Random numero;
		numero = new Random();
		x = numero.nextInt(4); // 0 - izq ; 1 - der ; 2 - up ; 3 - down
		Ocultar(area);

		switch (x) {
		case 0:
			Izquierda(0);
			comerTrogol();
			comerHamburguesa();
			break;

		case 1:
			Derecha(ancho);
			comerTrogol();
			comerHamburguesa();
			break;

		case 2:
			Subir(0);
			comerTrogol();
			comerHamburguesa();
			break;

		case 3:
			Bajar(alto);
			comerTrogol();
			comerHamburguesa();
			break;
		}
		Mostrar(area);
	}

	/**
	 * Método comerTrogol().
	 * 
	 * Cuando la posición de un fantasma coincide con la del trogol, activamos
	 * un sonido específico y volvemos a lanzar un trogol en otra posición
	 * aleatoria.
	 */
	private void comerTrogol() {
		if (getX() == trogol.getX() && getY() == trogol.getY()) {
			SISTEMA.activarSonido(SISTEMA.getSndFile() + "pacman_eatghost.wav");
			trogol.Ocultar(area);
			trogol.ColocarAleatorio(ancho, alto);
			trogol.Mostrar(area);
			campoEnergia.setValue((int) campoEnergia.getValue() - 10);
		}
	}

	/**
	 * Método comerHamburguesa().
	 * 
	 * Cuando la posición de un fantasma coincide con la de una hamburguesa,
	 * activamos un sonido específico y volvemos a lanzar la misma hamburguesa
	 * en otra posición aleatoria.
	 */
	private void comerHamburguesa() {
		for (i = 0; i < maxhamburguesas; i++) {
			if (getX() == hamburguesa[i].getX() && getY() == hamburguesa[i].getY()) {
				SISTEMA.activarSonido(SISTEMA.getSndFile() + "pacman_chomp.wav");
				hamburguesa[i].Ocultar(area);
				hamburguesa[i].ColocarAleatorio(ancho, alto);
				hamburguesa[i].Mostrar(area);

			}
		}
	}
}
