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
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextArea;

/**
 * Aplicación Java Curso Java Uex Escuela de Ingenierías Industriales.
 *
 * @author Antonio Horrillo Horrillo
 * @version 2.0.0.0
 */
public class Info {

	/**
	 * Atributos.
	 */
	private JFrame frameInfo;
	private JLabel txtSO;
	private JLabel txtJH;
	private JLabel lblDbHome;
	private JLabel txtDB;
	private JLabel lblTrogol;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Info window = new Info();
					window.frameInfo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Info() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameInfo = new JFrame();
		frameInfo.getContentPane().setBackground(Color.GRAY);
		frameInfo.setBounds(100, 100, 640, 480);
		frameInfo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameInfo.getContentPane().setLayout(null);
		frameInfo.setLocationRelativeTo(null);
		
		lblTrogol = new JLabel("Trogol 2.0");
		lblTrogol.setBounds(10, 11, 604, 29);
		lblTrogol.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrogol.setForeground(new Color(0,150,0));
		lblTrogol.setFont(new Font("Tahoma", Font.BOLD, 24));
		frameInfo.getContentPane().add(lblTrogol);
		
		JLabel lblSO = new JLabel("Sistema Operativo:");
		lblSO.setForeground(Color.DARK_GRAY);
		lblSO.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSO.setBounds(10, 51, 140, 20);
		frameInfo.getContentPane().add(lblSO);
		
		txtSO = new JLabel("");
		txtSO.setForeground(Color.ORANGE);
		txtSO.setBounds(160, 51, 454, 20);
		frameInfo.getContentPane().add(txtSO);
		
		JLabel lblJH = new JLabel("Java Home:");
		lblJH.setForeground(Color.DARK_GRAY);
		lblJH.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblJH.setBounds(10, 82, 140, 20);
		frameInfo.getContentPane().add(lblJH);
		
		txtJH = new JLabel("");
		txtJH.setForeground(Color.ORANGE);
		txtJH.setBounds(160, 82, 454, 20);
		frameInfo.getContentPane().add(txtJH);
		
		lblDbHome = new JLabel("DB Home:");
		lblDbHome.setForeground(Color.DARK_GRAY);
		lblDbHome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDbHome.setBounds(10, 113, 140, 20);
		frameInfo.getContentPane().add(lblDbHome);
		
		txtDB = new JLabel("");
		txtDB.setForeground(Color.ORANGE);
		txtDB.setBounds(160, 113, 454, 20);
		frameInfo.getContentPane().add(txtDB);
		
		JTextArea txtCopyright = new JTextArea();
		txtCopyright.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtCopyright.setWrapStyleWord(true);
		txtCopyright.setEditable(false);
		txtCopyright.setText("Proyecto Trogol v2.0. Copyright (C) 2016 Antonio Horrillo Horrillo.\r\n\r\nCurso de perfeccionamiento Java. Escuela de Ingenierías Industriales UEX.\r\n\r\nThis program is free software: you can redistribute it and/or modify \r\nit under the terms of the GNU General Public License as published by\r\nthe Free Software Foundation, either version 3 of the License, or (at \r\nyour option) any later version.\r\n\r\nThis program is distributed in the hope that it will be useful, but \r\nWITHOUT ANY WARRANTY; without even the implied warranty of \r\nMERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See \r\nthe GNU General Public License for more details.\r\nYou should have received a copy of the GNU General Public License \r\nalong with this program.  If not, see <http://www.gnu.org/licenses/>.");
		txtCopyright.setBackground(Color.LIGHT_GRAY);
		txtCopyright.setBounds(10, 144, 604, 286);
		frameInfo.getContentPane().add(txtCopyright);
	}

	/**
	 * Asignamos el texto del sistema operativo.
	 * 
	 * @param txtSO
	 */
	public void setTxtSO(String txtSO) {
		this.txtSO.setText(txtSO);
	}

	/**
	 * Asignamos el texto de la ruta de java.
	 * 
	 * @param txtJH
	 */
	public void setTxtJH(String txtJH) {
		this.txtJH.setText(txtJH);
	}

	/**
	 * Asignamos el texto de la ruta de la base de datos.	 
	 * 
	 * @param txtDB
	 */
	public void setTxtDB(String txtDB) {
		this.txtDB.setText(txtDB);
	}
	
	/**
	 * Asignamos el icono de la etiqueta de título.
	 * 
	 * @param iconLogo
	 */
	public void setlblTrogolIcon(Icon iconLogo) {
		this.lblTrogol.setIcon(iconLogo);
	}
	
	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frameInfo;
	}

	/**
	 * @param frame
	 *            the frame to set
	 */
	public void setFrame(JFrame frame) {
		this.frameInfo = frame;
		frameInfo.getContentPane().setBackground(Color.GRAY);
	}
}
