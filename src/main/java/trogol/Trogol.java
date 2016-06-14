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
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Image;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import jiconfont.icons.FontAwesome;
import jiconfont.swing.IconFontSwing;
import java.io.File;

/**
 * Aplicación Java Curso Java Uex Escuela de Ingenierías Industriales.
 *
 * @author Antonio Horrillo Horrillo
 * @version 2.0.0.0
 */
public class Trogol {

	/**
	 * Atributos.
	 */
	private static final Logger LOG = Logger.getLogger(Trogol.class);
	private final Dao DAO = new Dao();
	private final Sistema SISTEMA = new Sistema();
	private final File FICDB = new File(SISTEMA.getDbFile());
	private final File DIRDB = new File(SISTEMA.getDbRuta());
	private String[] os;
	private JButton btnregistro;
	private JButton btnlogout;
	private JLabel lbltitulo;
	private JLabel lblnombre;
	private JLabel lblclave;
	private Icon iconIn;
	private Icon iconOut;
	private Icon iconDb;
	private Icon iconLogo;
	private Icon icon19;
	private Image iconFrame;
	private JLabel lblmsg;
	private JFrame frmTrogol;
	private JTextField txtnombre;
	private JTextField txtcontraseña;
	private JButton btnlogin;
	private VentanaPrincipal vp = new VentanaPrincipal();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Trogol window = new Trogol();
					window.frmTrogol.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Trogol() {
		sistemaOperativo();
		persistencia();
		iconos();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTrogol = new JFrame();
		// Inicio definición del icono del frame.
		frmTrogol.setIconImage(iconFrame);
		// Fin definición del icono del frame.
		frmTrogol.setTitle("Trogol");
		frmTrogol.getContentPane().setBackground(Color.GRAY);
		frmTrogol.getContentPane().setForeground(Color.BLACK);
		frmTrogol.setBounds(100, 100, 500, 350);
		frmTrogol.setLocationRelativeTo(null);
		frmTrogol.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTrogol.getContentPane().setLayout(null);

		lbltitulo = new JLabel("Trogol 2.0");
		// Inicio definición del icono del frame.
		lbltitulo.setIcon(iconLogo);
		// Fin definición del icono del frame.
		lbltitulo.setForeground(new Color(0,150,0));
		lbltitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitulo.setFont(new Font("Tahoma", Font.BOLD, 22));
		lbltitulo.setBounds(10, 23, 464, 39);
		frmTrogol.getContentPane().add(lbltitulo);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(106, 89, 271, 100);
		frmTrogol.getContentPane().add(panel);
		panel.setLayout(null);

		lblnombre = new JLabel("Nombre");
		lblnombre.setForeground(Color.DARK_GRAY);
		lblnombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblnombre.setBounds(10, 29, 59, 14);
		panel.add(lblnombre);

		lblclave = new JLabel("Contraseña");
		lblclave.setForeground(Color.DARK_GRAY);
		lblclave.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblclave.setBounds(10, 60, 80, 14);
		panel.add(lblclave);

		txtnombre = new JTextField();
		txtnombre.setBounds(100, 27, 161, 20);
		panel.add(txtnombre);
		txtnombre.setColumns(10);

		txtcontraseña = new JTextField();
		txtcontraseña.setBounds(100, 58, 161, 20);
		panel.add(txtcontraseña);
		txtcontraseña.setColumns(10);

		btnlogin = new JButton("Login");
		// Inicio definición del icono del frame.
		btnlogin.setIcon(iconIn);
		// Fin definición del icono del frame.
		btnlogin.setBackground(SystemColor.control);
		btnlogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					login();
				} catch (Exception ex) {
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnlogin.setBackground(SystemColor.controlHighlight);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnlogin.setBackground(SystemColor.control);
			}
		});
		btnlogin.setBounds(181, 270, 120, 30);
		frmTrogol.getContentPane().add(btnlogin);

		btnlogout = new JButton("Logout");
		// Inicio definición del icono del frame.
		btnlogout.setIcon(iconOut);
		// Fin definición del icono del frame.
		btnlogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/**
				 * Salimos de la aplicación.
				 */
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnlogout.setBackground(SystemColor.controlHighlight);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnlogout.setBackground(SystemColor.control);
			}
		});
		btnlogout.setBackground(SystemColor.menu);
		btnlogout.setBounds(354, 270, 120, 30);
		frmTrogol.getContentPane().add(btnlogout);

		btnregistro = new JButton("Registro");
		// Inicio definición del icono del frame.
		btnregistro.setIcon(iconDb);
		// Fin definición del icono del frame.
		btnregistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					registro();
				} catch (Exception ex) {
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnlogout.setBackground(SystemColor.controlHighlight);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnlogout.setBackground(SystemColor.control);
			}
		});
		btnregistro.setBackground(SystemColor.menu);
		btnregistro.setBounds(10, 270, 120, 30);
		frmTrogol.getContentPane().add(btnregistro);

		lblmsg = new JLabel("");
		lblmsg.setForeground(Color.RED);
		lblmsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblmsg.setBounds(10, 219, 464, 14);
		frmTrogol.getContentPane().add(lblmsg);
	}

	/**
	 * Método sistemaOperativo().
	 *
	 * Identificamos el sistema operativo en el que se ejecuta la aplicación.
	 */
	private void sistemaOperativo() {
		// Iniciamos el Logger. Configuración en log4j.properties
		// trace, debug, info, warn, error, fatal.
		// BasicConfigurator.configure();
		LOG.info("Iniciando la aplicacion...");
		// Obtenemos el nombre del sistema operativo.
		this.os = SISTEMA.getSistema().split(" ");
		// Creamos el directorio ../db para la base de datos.
		this.DIRDB.mkdir();
		// Mensajes con el sistema operativo y la ruta de jre.
		System.out.println("Iniciando la aplicacion...");
		System.out.println("Sistema Operativo: "+SISTEMA.sistemaOperativo());
		System.out.println("Java Home: "+SISTEMA.javaHome());
	}

	/**
	 * Método persistencia().
	 *
	 * Establecemos conexión con la base de datos. Comprobamos si el archivo de
	 * la base de datos existe o no. Si no existe lo creamos.
	 *
	 * Encerramos en un try - catch la consulta a la base de datos.
	 */
	private void persistencia() {
		try {
			// Comprobamos la existencia del archivo de la base de datos.
			if (FICDB.exists()) {
				// Mensajes de estado.
				System.out.println("Encontrado archivo de base de datos.");
				System.out.println(FICDB.getAbsolutePath());
				// Log info de conexión.
				LOG.info("Encontrado archivo de base de datos.");
			} else {
				System.out.println("Archivo de base de datos no existe.");
				JOptionPane.showMessageDialog(null, "No existe el archivo de la base "
						+ "de datos. Creando un nuevo archivo en:\n" + SISTEMA.getDbRuta());
				System.out.println("Creando archivo de base de datos...");
				// Metodos de la clase Dao() para crear la base de datos y
				// tablas.
				DAO.crearDB();
				DAO.crearTabla();
				// Log info de conexión.
				LOG.info("Creando archivo de base de datos...");
			}
		} catch (Exception ex) {
			System.out.println(ex);
			// Log fatal de conexión.
			LOG.fatal("Error al crear la base de datos: ", ex);
			// Mensaje de fallo.
			JOptionPane.showMessageDialog(null,
					"No se ha podido crear la " + "base de datos.\n" + "Pulse en aceptar para salir de la aplicación.");
			// Forzamos salida de la aplicación.
			System.exit(0);
		}
	}

	/**
	 * Método iconos().
	 *
	 * Condiciones de inicio de la aplicación.
	 */
	private void iconos() {
		// Establecemos el icono de la barra de menus de la aplicación.
		this.iconFrame = new ImageIcon(getClass().getResource("/Trogol.png")).getImage();

		// Iconos Font Awesome para botones de la aplicacion.
		IconFontSwing.register(FontAwesome.getIconFont());
		this.iconOut = IconFontSwing.buildIcon(FontAwesome.SIGN_OUT, 20, new Color(150, 0, 0));
		this.iconDb = IconFontSwing.buildIcon(FontAwesome.DATABASE, 20, new Color(0, 150, 0));
		this.iconIn = IconFontSwing.buildIcon(FontAwesome.SIGN_IN, 20, new Color(0, 150, 0));
		this.icon19 = IconFontSwing.buildIcon(FontAwesome.SORT_NUMERIC_ASC, 20, new Color(0, 150, 0));

		// Identificamos el sistema operativo y asignamos icono correspondiente.
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
	 * Método login().
	 *
	 * Realizamos login en la aplicación si existe el usuario en la base de
	 * datos.
	 */
	private void login() {
		try {
			if (txtnombre.getText() != null && !"".equals(txtnombre.getText()) && txtcontraseña.getText() != null
					&& !"".equals(txtcontraseña.getText())) {
				if (DAO.comprobarUsuario(txtnombre.getText(), txtcontraseña.getText())) {
					LOG.info("Se realiza un inicio de sesión con el usuario " + txtnombre.getText() + ".");
					lblmsg.setText("Inicio de sesión correcto.");

					/**
					 * Opciones para el número de hamburguesas.
					 */
					Object[] opcionesHamburguesas = { 1, 3, 5, 7, 9 };
					int maxhamburguesas = (int) JOptionPane.showInputDialog(frmTrogol,
							"Elija el número de hamburguesas simultaneas en el juego:", "Hamburguesas",
							JOptionPane.PLAIN_MESSAGE, icon19, opcionesHamburguesas, 5);

					/**
					 * Opciones para el número de fantasmas.
					 */
					Object[] opcionesFantasmas = { 1, 3, 5, 7, 9 };
					int maxfantasmas = (int) JOptionPane.showInputDialog(frmTrogol,
							"Elija el número de fantasmas simultaneos en el juego:", "Fantasmas",
							JOptionPane.PLAIN_MESSAGE, (Icon) icon19, opcionesFantasmas, 5);

					/**
					 * Asignamos en la ventana principal el nombre del usuario,
					 * el numero de hamburguesas y de fantasmas.
					 */
					vp.setMaxFantasmas(maxfantasmas);
					vp.setMaxHamburguesas(maxhamburguesas);
					vp.setLblUsuario(txtnombre.getText());

					/**
					 * Frame principal.
					 */
					vp.getFrame().setVisible(true);

					/**
					 * Ocultamos el frame del login.
					 */
					frmTrogol.dispose();

				} else {
					lblmsg.setText("El usuario " + txtnombre.getText() + " no existe o es incorrecto.");
				}
			} else {
				lblmsg.setText("Escriba el nombre de usuario y una contraseña.");
			}
		} catch (Exception ex) {
			System.err.println(ex);
			LOG.fatal("No se ha podido iniciar sesión: ", ex);
			lblmsg.setText("No se ha podido iniciar sesión.");
		}

	}

	/**
	 * Método registro().
	 *
	 * Realizamos el registro de un usuario en la base de datos.
	 */
	private void registro() {
		try {
			if (txtnombre.getText() != null && !"".equals(txtnombre.getText()) && txtcontraseña.getText() != null
					&& !"".equals(txtcontraseña.getText())) {
				if (!DAO.comprobarUsuario(txtnombre.getText(), txtcontraseña.getText())) {
					DAO.insertarUsuario(txtnombre.getText(), txtcontraseña.getText());
					lblmsg.setText("Usuario " + txtnombre.getText() + " registrado en la base de datos.");
				} else {
					lblmsg.setText("El usuario " + txtnombre.getText() + " existe en la base de datos.");
				}
			} else {
				lblmsg.setText("Escriba el nombre de usuario y una contraseña.");
			}
		} catch (Exception ex) {
			System.err.println(ex);
			LOG.fatal("No se ha podido registrar el usuario: ", ex);
			lblmsg.setText("No se ha podido registrar el usuario.");
		}
	}
}