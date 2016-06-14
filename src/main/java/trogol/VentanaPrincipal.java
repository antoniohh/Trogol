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
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import org.apache.log4j.Logger;
import jiconfont.icons.FontAwesome;
import jiconfont.swing.IconFontSwing;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 * Aplicación Java Curso Java Uex Escuela de Ingenierías Industriales.
 *
 * @author Antonio Horrillo Horrillo
 * @version 2.0.0.0
 */
public class VentanaPrincipal {

	/**
	 * Atributos.
	 */
	private static final Logger LOG = Logger.getLogger(VentanaPrincipal.class);
	private Sistema SISTEMA = new Sistema();
	private JFrame frmVp;
	private JPanel panel;
	private JButton btninicio;
	private JButton btnInfo;
	private JLabel lblPuntos;
	private JSpinner campoPuntos;
	private JLabel lblEnerga;
	private JSpinner campoEnergia;
	private JButton btnLeft;
	private JButton btnUp;
	private JButton btnDown;
	private JButton btnRight;
	private JLabel lbltitulo;
	private Image iconFrame;
	private JLabel lblusuario;
	private int maxhamburguesas;
	private int maxfantasmas;
	private int i, aleatorio, espera, energia;
	private Icon arrowLeft;
	private Icon arrowRight;
	private Icon arrowUp;
	private Icon arrowDown;
	private Icon iconLogo;
	private Icon iconInfo;
	private Icon iconEmpezar;
	private Random numero = new Random();
	private String[] os;
	private Comida[] hamburguesa;
	private Fantasma[] fantasma;
	private ImagenDinamica trogol;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frmVp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		iconos();
		initialize();
		controlBotonesDireccion(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 800, 650);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		frmVp.setLocationRelativeTo(null);
		// Inicio definición del icono del frame.
		frmVp.setIconImage(iconFrame);
		// Fin definición del icono del frame.

		lbltitulo = new JLabel("Trogol 2.0");
		// Inicio definición del icono del frame.
		lbltitulo.setIcon(iconLogo);
		// Fin definición del icono del frame.

		lbltitulo.setForeground(new Color(0,150,0));
		lbltitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lbltitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitulo.setBounds(10, 11, 764, 30);
		getFrame().getContentPane().add(lbltitulo);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(17, 165, 750, 350);
		getFrame().getContentPane().add(panel);

		btninicio = new JButton("Empezar");
		// Inicio definición del icono del frame.
		btninicio.setIcon(iconEmpezar);
		// Fin definición del icono del frame.

		btninicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					/**
					 * Definimos las variables locales necesarias.
					 */
					Graphics g = panel.getGraphics();
					hamburguesa = new Comida[maxhamburguesas];
					fantasma = new Fantasma[maxfantasmas];

					/**
					 * Activamos los botones de dirección y desactivamos el
					 * botón emppezar.
					 */
					controlBotonesDireccion(true);
					controlBotonEmpezar(false);

					/**
					 * Iniciamos el Trogol.
					 */
					SISTEMA.activarSonido(SISTEMA.getSndFile() + "pacman_beginning.wav");
					trogol = new ImagenDinamica("/monster.jpg");
					trogol.ColocarAleatorio(panel.getWidth(), panel.getHeight());
					trogol.Mostrar(g);

					/**
					 * Iniciamos las hamburguesas.
					 */
					for (i = 0; i < maxhamburguesas; i++) {
						hamburguesa[i] = new Comida("/Hamburguesa.jpg");
						hamburguesa[i].ColocarAleatorio(panel.getWidth(), panel.getHeight());
						hamburguesa[i].Mostrar(g);
					}

					/**
					 * Iniciamos los fantasmas.
					 */
					for (i = 0; i < maxfantasmas; i++) {
						aleatorio = numero.nextInt(10) + 5;
						espera = aleatorio * 100;
						fantasma[i] = new Fantasma("/fantasma.jpg", panel.getWidth(), panel.getHeight(), g, espera,
								trogol, hamburguesa, maxhamburguesas, campoEnergia);
					}

					/**
					 * Registramos el inicio de la partida en el log.
					 */
					LOG.info("Se ha iniciado una partida con " + maxhamburguesas + " hamburguesas y " + maxfantasmas
							+ " fantasmas.");
				} catch (Exception ex) {
					System.err.println("No ha sido posible crear un Trogol: " + ex);
					LOG.fatal("No ha sido posible iniciar la partida: ", ex);
					// mensajes.setText("No ha sido posible crear el thread del
					// Fantasma ");
				}
			}
		});
		btninicio.setBounds(17, 110, 120, 30);
		getFrame().getContentPane().add(btninicio);

		lblusuario = new JLabel("Bienvenido");
		lblusuario.setForeground(Color.ORANGE);
		lblusuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblusuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblusuario.setBounds(10, 52, 764, 30);
		frmVp.getContentPane().add(lblusuario);

		lblPuntos = new JLabel("Puntos");
		lblPuntos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPuntos.setForeground(Color.DARK_GRAY);
		lblPuntos.setBounds(249, 109, 60, 30);
		frmVp.getContentPane().add(lblPuntos);

		lblEnerga = new JLabel("Energía");
		lblEnerga.setForeground(Color.DARK_GRAY);
		lblEnerga.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEnerga.setBounds(416, 109, 60, 30);
		frmVp.getContentPane().add(lblEnerga);

		btnInfo = new JButton("Info");
		// Inicio definición del icono del frame.
		btnInfo.setIcon(iconInfo);
		// Fin definición del icono del frame.

		btnInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Frame de información. Establecemos los parametros y lo visializamos.
				Info info = new Info();
				info.getFrame().setVisible(true);
				info.setTxtSO(SISTEMA.sistemaOperativo());
				info.setTxtJH(SISTEMA.javaHome());
				info.setTxtDB(SISTEMA.getDbFile());
				info.getFrame().setIconImage(iconFrame);
				info.setlblTrogolIcon(iconLogo);
			}
		});
		btnInfo.setBounds(642, 110, 120, 30);
		frmVp.getContentPane().add(btnInfo);

		campoPuntos = new JSpinner();
		campoPuntos.setFocusable(false);
		campoPuntos.setModel(new SpinnerNumberModel(new Integer(10), null, null, new Integer(1)));
		campoPuntos.setBounds(319, 109, 50, 30);
		frmVp.getContentPane().add(campoPuntos);
		campoPuntos.setValue(0);

		campoEnergia = new JSpinner();
		campoEnergia.setFocusable(false);
		campoEnergia.setBounds(486, 109, 50, 30);
		frmVp.getContentPane().add(campoEnergia);
		campoEnergia.setValue(100);

		JPanel panelMarcador = new JPanel();
		panelMarcador.setBackground(Color.LIGHT_GRAY);
		panelMarcador.setBounds(233, 92, 320, 62);
		frmVp.getContentPane().add(panelMarcador);

		btnLeft = new JButton("Izquierda");
		// Inicio definición del icono del frame.
		btnLeft.setIcon(arrowLeft);
		// Fin definición del icono del frame.

		btnLeft.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Graphics g = panel.getGraphics();
					trogol.Ocultar(g);
					trogol.Izquierda(0);
					trogol.Mostrar(g);
					comerHamburguesa();
					comerFantasma();
					campoPuntos.setValue((int) campoPuntos.getValue() + 1);
					campoEnergia.setValue((int) campoEnergia.getValue() - 1);
					controlEnergia();
				} catch (Exception ex) {
				}
			}
		});

		btnLeft.setBounds(176, 548, 140, 30);
		frmVp.getContentPane().add(btnLeft);

		btnUp = new JButton("Arriba");
		// Inicio definición del icono del frame.
		btnUp.setIcon(arrowUp);
		// Fin definición del icono del frame.

		btnUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Graphics g = panel.getGraphics();
					trogol.Ocultar(g);
					trogol.Subir(0);
					trogol.Mostrar(g);
					comerHamburguesa();
					comerFantasma();
					campoPuntos.setValue((int) campoPuntos.getValue() + 1);
					campoEnergia.setValue((int) campoEnergia.getValue() - 1);
					controlEnergia();
				} catch (Exception ex) {
				}
			}
		});
		btnUp.setBounds(326, 526, 140, 30);
		frmVp.getContentPane().add(btnUp);

		btnDown = new JButton("Abajo");
		// Inicio definición del icono del frame.
		btnDown.setIcon(arrowDown);
		// Fin definición del icono del frame.

		btnDown.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Graphics g = panel.getGraphics();
					trogol.Ocultar(g);
					trogol.Bajar(panel.getHeight());
					trogol.Mostrar(g);
					comerHamburguesa();
					comerFantasma();
					campoPuntos.setValue((int) campoPuntos.getValue() + 1);
					campoEnergia.setValue((int) campoEnergia.getValue() - 1);
					controlEnergia();
				} catch (Exception ex) {
				}
			}
		});
		btnDown.setBounds(326, 570, 140, 30);
		frmVp.getContentPane().add(btnDown);

		btnRight = new JButton("Derecha");
		// Inicio definición del icono del frame.
		btnRight.setIcon(arrowRight);
		// Fin definición del icono del frame.

		btnRight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Graphics g = panel.getGraphics();
					trogol.Ocultar(g);
					trogol.Derecha(panel.getWidth());
					trogol.Mostrar(g);
					comerHamburguesa();
					comerFantasma();
					campoPuntos.setValue((int) campoPuntos.getValue() + 1);
					campoEnergia.setValue((int) campoEnergia.getValue() - 1);
					controlEnergia();
				} catch (Exception ex) {
				}
			}
		});
		btnRight.setBounds(476, 548, 140, 30);
		frmVp.getContentPane().add(btnRight);
	}

	/**
	 * Método setLblUsuario(String usuario).
	 * 
	 * Establecemos el nombre del usuario en el mensaje de bienvenida.
	 * 
	 * @param usuario
	 */
	public void setLblUsuario(String usuario) {
		lblusuario.setText("Bienvenido " + usuario);
	}

	/**
	 * Método setMaxHamburguesas(int maxhamburguesas).
	 * 
	 * Establecemos el número máximo de hamburguesas.
	 * 
	 * @param maxhamburguesas
	 */
	public void setMaxHamburguesas(int maxhamburguesas) {
		this.maxhamburguesas = maxhamburguesas;
	}

	/**
	 * Método setMaxFantasmas(int maxfantasmas).
	 * 
	 * Establecemos el número máximo de fantasmas.
	 * 
	 * @param maxfantasmas
	 */
	public void setMaxFantasmas(int maxfantasmas) {
		this.maxfantasmas = maxfantasmas;
	}

	/**
	 * Método comerHamburguesa().
	 * 
	 * Activamos los sonidos del juego.
	 */
	public void comerHamburguesa() {
		try {
			for (i = 0; i < maxhamburguesas; i++) {
				if (trogol.getX() == hamburguesa[i].getX() && trogol.getY() == hamburguesa[i].getY()) {
					// Activamos sonido
					SISTEMA.activarSonido(SISTEMA.getSndFile() + "pacman_eatfruit.wav");
					// Habilitamos una nueva hamburguesa en una nueva localización aleatoria.
					Graphics g = panel.getGraphics();
					//hamburguesa[i].Ocultar(g);
					hamburguesa[i].ColocarAleatorio(panel.getWidth(), panel.getHeight());
					hamburguesa[i].Mostrar(g);
					// Asignamos la energía
					hamburguesa[i].energizar();
					energia = (int) campoEnergia.getValue();
					campoEnergia.setValue(energia + hamburguesa[i].getEnergia());
				}
			}
		} catch (Exception ex) {
			System.err.println(ex);
			LOG.fatal(ex);
		}
	}

	/**
	 * Método comerFantasma().
	 * 
	 * Activamos los sonidos del juego.
	 */
	public void comerFantasma() {
		try {
			for (i = 0; i < maxfantasmas; i++) {
				if (trogol.getX() == fantasma[i].getX() && trogol.getY() == fantasma[i].getY()) {
					// Activamos sonido
					SISTEMA.activarSonido(SISTEMA.getSndFile() + "pacman_eatghost.wav");
					// Habilitamos un nuevo trogol en una nueva localización aleatoria.
					Graphics g = panel.getGraphics();
					trogol.Ocultar(g);
					trogol.ColocarAleatorio(panel.getWidth(), panel.getHeight());
					trogol.Mostrar(g);
					// Asignamos la energía
					campoEnergia.setValue((int) campoEnergia.getValue() - 10);				
				}
			}
		} catch (Exception ex) {
			System.err.println(ex);
			LOG.fatal(ex);
		}
	}

	/**
	 * Método controlEnergia().
	 * 
	 * Realizamos un control sobre el campo energia del trogol, de forma que al
	 * perder toda su energía, se finaliza la partida.
	 */
	public void controlEnergia() {
		try {
			if ((int) campoEnergia.getValue() <= 0) {
				// Mostramos mensaje informando del final de la partida.
				JOptionPane.showMessageDialog(frmVp, "Game Over.\nHas perdido toda la energía del Trogol.");
				// Redibujamos el panel limpiando los elementos dibujados en el, dejandolo preparado para empezar otra partida.
				panel.repaint();
				// Habilitamos en boton empezar y deshabilitamos los de dirección.
				controlBotonEmpezar(true);
				controlBotonesDireccion(false);
				// Asignamos la energía inicial y la puntuación.
				campoEnergia.setValue(100);
				campoPuntos.setValue(0);
				// Mensaje de log informando del final de la partida.
				LOG.info("Game Over. La partida ha finalizado.");
			}

		} catch (Exception ex) {
			System.err.println(ex);
			LOG.fatal(ex);
		}
	}

	/**
	 * Método controlBotonesDireccion(boolean estado).
	 * 
	 * Gestionamos el estado del boton en habilitado o deshabilitado.
	 * 
	 * @param estado
	 */
	public void controlBotonesDireccion(boolean estado) {
		btnLeft.setEnabled(estado);
		btnUp.setEnabled(estado);
		btnRight.setEnabled(estado);
		btnDown.setEnabled(estado);
	}

	/**
	 * Método controlBotonEmpezar(boolean estado).
	 * 
	 * Gestionamos el estado del boton en habilitado o deshabilitado.
	 * 
	 * @param estado
	 */
	public void controlBotonEmpezar(boolean estado) {
		btninicio.setEnabled(estado);
	}

	/**
	 * Método iconos().
	 *
	 * Condiciones de inicio de la aplicación. Asignamos los iconos.
	 */
	private void iconos() {
		// Establecemos el icono del frame del juego.
		this.iconFrame = new ImageIcon(getClass().getResource("/Trogol.png")).getImage();

		// Iconos Font Awesome para los botones del juego.
		IconFontSwing.register(FontAwesome.getIconFont());
		this.arrowLeft = IconFontSwing.buildIcon(FontAwesome.ARROW_CIRCLE_LEFT, 20, new Color(150, 0, 0));
		this.arrowUp = IconFontSwing.buildIcon(FontAwesome.ARROW_CIRCLE_UP, 20, new Color(150, 0, 0));
		this.arrowDown = IconFontSwing.buildIcon(FontAwesome.ARROW_CIRCLE_DOWN, 20, new Color(150, 0, 0));
		this.arrowRight = IconFontSwing.buildIcon(FontAwesome.ARROW_CIRCLE_RIGHT, 20, new Color(150, 0, 0));
		this.iconInfo = IconFontSwing.buildIcon(FontAwesome.INFO_CIRCLE, 20, new Color(0, 150, 0));
		this.iconEmpezar = IconFontSwing.buildIcon(FontAwesome.PLAY_CIRCLE, 20, new Color(0, 150, 0));

		/**
		 * Identificamos el sistema operativo y asignamos icono correspondiente.
		 */
		this.os = SISTEMA.getSistema().split(" ");
		if (this.os[0] != null) {
			switch (os[0]) {
			case "Windows":
				this.iconLogo = IconFontSwing.buildIcon(FontAwesome.WINDOWS, 25, new Color(0, 150, 0));
				break;
			case "Linux":
				this.iconLogo = IconFontSwing.buildIcon(FontAwesome.LINUX, 25, new Color(0, 150, 0));
				break;
			case "Mac":
				this.iconLogo = IconFontSwing.buildIcon(FontAwesome.APPLE, 25, new Color(0, 150, 0));
				break;
			default:
				this.iconLogo = IconFontSwing.buildIcon(FontAwesome.DESKTOP, 25, new Color(0, 150, 0));
			}
		} else {
			this.iconLogo = IconFontSwing.buildIcon(FontAwesome.DESKTOP, 25, new Color(0, 150, 0));
		}
	}

	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frmVp;
	}

	/**
	 * @param frame
	 *            the frame to set
	 */
	public void setFrame(JFrame frame) {
		this.frmVp = frame;
		frmVp.getContentPane().setBackground(Color.GRAY);
	}
}