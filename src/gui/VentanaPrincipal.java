package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import concesionario.Coche;
import concesionario.Marca;
import concesionario.Modelo;




import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

/**
 * Ventana gráfica principal en la que se introducen todos los elementos y se harán visibles o no según se necesiten en las ventanas
 * hijas 
 * 
 * @author Javier Benítez del Pozo
 *
 */
public class VentanaPrincipal extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected final JPanel contentPanel = new JPanel();
	protected JTextField textField;
	protected JLabel lblMatricula;
	protected JLabel lblMarca;
	protected JLabel lblModelo;
	protected JRadioButton radioButtonPlata;
	protected JRadioButton radioButtonRojo;
	protected JRadioButton radioButtonAzul;
	protected final ButtonGroup buttonGroup = new ButtonGroup();
	protected JComboBox<Marca> comboBoxMarca;
	protected JComboBox<Modelo> comboBoxModelo;
	protected JButton annadir;
	protected JButton eliminar;
	protected JButton buttonAnterior;
	protected JButton buttonSiguiente;
	protected JButton buscar;
	protected JButton salir;
	protected JPanel panel;

	public VentanaPrincipal() {
		super();
		setResizable(false);
		setModal(true);
		setBounds(250, 180, 400, 240);
		setLocationRelativeTo(null);
		
		lblMatricula = new JLabel("Matr\u00EDcula");
		lblMatricula.setBounds(26, 11, 76, 30);
		
		textField = new JTextField();
		textField.setToolTipText("La matr\u00EDcula debe tener el formato 0000XXX \u00F3 0000-XXX");
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if(!Coche.esValida(textField.getText()))
					textField.setForeground(java.awt.Color.RED);
				else
					textField.setForeground(java.awt.Color.BLACK);
			}
		});
		textField.setBounds(106, 16, 108, 20);
		textField.setColumns(10);
		
		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(26, 72, 49, 14);
		
		comboBoxMarca = new JComboBox<Marca>();
		comboBoxMarca.setBounds(106, 68, 108, 22);
		comboBoxModelo = new JComboBox<Modelo>();
		comboBoxModelo.setBounds(106, 118, 108, 22);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(26, 122, 49, 14);
		
		annadir = new JButton("A\u00F1adir");
		annadir.setBounds(205, 164, 86, 23);
		
		eliminar = new JButton("Eliminar");
		eliminar.setBounds(205, 164, 86, 23);
		
		buttonAnterior = new JButton();
		ImageIcon izda = new ImageIcon("src/imagenes/flechaizquierda.png");
		buttonAnterior.setIcon(izda);
		getContentPane().add(buttonAnterior);
		buttonAnterior.setBounds(205, 164, 43, 23);
		
		buttonSiguiente = new JButton();
		ImageIcon dcha = new ImageIcon("src/imagenes/flechaderecha.png");
		buttonSiguiente.setIcon(dcha);
		getContentPane().add(buttonSiguiente);
		buttonSiguiente.setBounds(248, 164, 43, 23);
		
		buscar = new JButton("Buscar");
		buscar.setBounds(205, 164, 86, 23);
		
		salir = new JButton("Salir");
		salir.setBounds(300, 164, 65, 23);
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		
		getContentPane().setLayout(null);
		getContentPane().add(lblMarca);
		getContentPane().add(lblModelo);
		getContentPane().add(lblMatricula);
		
		panel = new JPanel();
		panel.setToolTipText("Elige uno de los 3 colores disponibles");
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Color", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(260, 12, 77, 98);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		radioButtonPlata = new JRadioButton("Plata");
		radioButtonPlata.setBounds(6, 16, 65, 23);
		panel.add(radioButtonPlata);
		buttonGroup.add(radioButtonPlata);
		radioButtonPlata.setSelected(true);
		
		radioButtonRojo = new JRadioButton("Rojo");
		radioButtonRojo.setBounds(6, 42, 65, 23);
		panel.add(radioButtonRojo);
		buttonGroup.add(radioButtonRojo);
		
		radioButtonAzul = new JRadioButton("Azul");
		radioButtonAzul.setBounds(6, 68, 65, 23);
		panel.add(radioButtonAzul);
		buttonGroup.add(radioButtonAzul);
		getContentPane().add(annadir);
		getContentPane().add(eliminar);
		getContentPane().add(buttonAnterior);
		getContentPane().add(buttonSiguiente);
		getContentPane().add(buscar);
		getContentPane().add(salir);
		getContentPane().add(comboBoxMarca);
		getContentPane().add(comboBoxModelo);
		getContentPane().add(textField);
		
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	}

}