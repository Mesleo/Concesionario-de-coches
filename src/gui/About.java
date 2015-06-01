package gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Color;

/**
 * 
 * @author Javier Benítez del Pozo
 *
 */
public class About extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public About() {
		setTitle("Sobre Concesionario");
		setResizable(false);
		setModal(true);
		setBounds(150, 150, 388, 232);
		
		JTextArea textArea = new JTextArea();
		textArea.setForeground(new Color(0, 128, 0));
		textArea.setFont(new Font("SimSun", Font.ITALIC, 13));
		textArea.setBackground(UIManager.getColor("Button.light"));
		textArea.setEditable(false);
		textArea.setText("Concesionario IES Gran Capit\u00E1n\r\n\r\nVersion: (1.0)\r\nBuild id: 0123456789\r\n(c) Copyright 2015.  All rights reserved.\r\n\r\nCreado por:\r\n\tJavier Benítez del Pozo");
		textArea.setBounds(0, 0, 382, 153);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 382, 156);
		
		JButton btnOk = new JButton("Aceptar");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnOk.setBounds(137, 169, 91, 23);
		
		getContentPane().setLayout(null);
		getContentPane().add(scrollPane);
		getContentPane().add(btnOk);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	}
	
}