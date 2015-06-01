package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JEditorPane;
import java.awt.Color;

/**
 * 
 * @author Javier Benítez del Pozo
 *
 */
public class Ayuda extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Ayuda() {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JEditorPane dtrpnHola = new JEditorPane();
		dtrpnHola.setContentType("text/html");
		dtrpnHola.setText("<h2>CONCESIONARIO</h2>\r\n<p>Este programa se encarga de gestionar un concesionario, almacenando coches mediante una matr\u00EDcula un\u00EDvoca y con propiedades como: color, marca y modelo.</p>\r\n<p>La matr\u00EDcula tendr\u00E1 el siguiente formato: 0000-XXX \u00F3 0000XXX.</p><br/><hr/>\r\n\r\n<h2>MANUAL:</h2>\r\n<h3>Archivo</h3>\r\n<ul>\r\n\t<li><strong>CTRL  + N:</strong> Para crear un concesionario nuevo</li>\r\n\t<li><strong>CTRL  + O:</strong> Para abrir un concesionario</li>\r\n\t<li><strong>CTRL  + S:</strong> Para guardar un concesionario</li>\r\n\t<li><strong>CTRL  + M:</strong> Para guardar un concesionario con un nombre espec\u00EDfico</li>\r\n</ul>\r\n<h3>Concesionario</h3>\r\n<ul>\r\n\t<li><strong>ALT  + A:</strong> Para crear un concesionario nuevo</li>\r\n\t<li><strong>ALT  + D:</strong> Para abrir un concesionario</li>\r\n\t<li><strong>ALT  + S:</strong> Para guardar un concesionario</li>\r\n\t<li><strong>ALT  + T:</strong> Para guardar un concesionario con un nombre espec\u00EDfico</li>\r\n</ul>\r\n<h3>Buscar</h3>\r\n<ul>\r\n\t<li><strong>ALT GR  + S:</strong> Para crear un concesionario nuevo</li>\r\n\t<li><strong>ALT GR + C:</strong> Para abrir un concesionario</li>\r\n</ul>\r\n<h3>Ayuda</h3>\r\n<ul>\r\n\t<li><strong>CTRL + May\u00FAs  + H:</strong> Para crear un concesionario nuevo</li>\r\n\t<li><strong>CTRL + May\u00FAs  + C:</strong> Para abrir un concesionario</li>\r\n</ul>");
		dtrpnHola.setBounds(10, 11, 664, 539);
		getContentPane().add(dtrpnHola);
		setBounds(670, 0, 700, 700);
	}
}
