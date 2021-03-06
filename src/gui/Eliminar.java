package gui;

import javax.swing.JOptionPane;

import concesionario.Coche;
import concesionario.Concesionario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Javier Ben�tez del Pozo
 *
 */
public class Eliminar extends VentanaPrincipal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean modificado;

	/**
	 * Create the dialog.
	 */
	public Eliminar(final Concesionario concesionario) {
		super();
		setTitle("Baja");
		
		annadir.setVisible(false);
		buscar.setVisible(false);
		buttonAnterior.setVisible(false);
		buttonSiguiente.setVisible(false);
		
		radioButtonPlata.setEnabled(false);
		radioButtonRojo.setEnabled(false);
		radioButtonAzul.setEnabled(false);
		
		comboBoxMarca.setEnabled(false);
		comboBoxModelo.setEnabled(false);
		
		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Coche coche = concesionario.get(textField.getText());
				if (coche != null) {
					mostrarCoche(coche);
					int n = JOptionPane.showOptionDialog(contentPanel,
							"�Est� seguro de que desea eliminarlo?", "Confirmar",
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, null, null);
					
					switch (n) {
					case JOptionPane.YES_OPTION:
						concesionario.eliminar(textField.getText());
						clear();
						Generar.setModificado(true);
						break;
					}
				} else {
					JOptionPane.showMessageDialog(contentPanel,
							"No se ha podido eliminar.", "Error",
							JOptionPane.ERROR_MESSAGE);
					Generar.setModificado(false);
				}
			}
		});
	}
	
	private void clear() {
		textField.setText("");
		buttonGroup.clearSelection();
		comboBoxMarca.setSelectedItem(null);
		comboBoxModelo.setSelectedItem(null);	
	}

	private void mostrarCoche(Coche coche) {
		switch (coche.getColor()) {
		case PLATA:
			radioButtonPlata.setSelected(true);
			break;
		case ROJO:
			radioButtonRojo.setSelected(true);
			break;
		case AZUL:
			radioButtonAzul.setSelected(true);
		}
		comboBoxMarca.addItem(coche.getModelo().getMarca());
		comboBoxMarca.setSelectedItem(coche.getModelo().getMarca());
		comboBoxModelo.addItem(coche.getModelo());
		comboBoxModelo.setSelectedItem(coche.getModelo());
	}

}