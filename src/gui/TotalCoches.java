package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import concesionario.Concesionario;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

/**
 * 
 * @author Javier Benítez del Pozo
 *
 */
public class TotalCoches extends VentanaPrincipal {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 * @param concesionario 
	 */
	public TotalCoches(Concesionario concesionario) {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 180, 451, 145);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHay = new JLabel("Hay");
		lblHay.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblHay.setBounds(101, 39, 33, 14);
		contentPane.add(lblHay);
		
		textField = new JTextField();
		textField.setBorder(null);
		textField.setFont(new Font("Times New Roman", textField.getFont().getStyle(), textField.getFont().getSize() + 4));
		textField.setEditable(false);
		textField.setBounds(144, 36, 33, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		int i = concesionario.size();
		String total = String.valueOf(i);
		textField.setText(total);
		
		JLabel lblCochesEnEl = new JLabel("coche/s en el concesionario");
		lblCochesEnEl.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCochesEnEl.setBounds(187, 33, 166, 27);
		contentPane.add(lblCochesEnEl);
	}
}
