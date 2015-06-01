package gui;

import java.awt.Component;
import java.awt.JobAttributes;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import concesionario.Concesionario;
import ficheros.Fichero;

import java.io.IOException;

/**
 * 
 * @author Javier Benítez del Pozo
 *
 */
public class Generar extends Principal{

	private static Annadir alta;
	private static Eliminar baja;
	private static boolean modificado = false;
	private static boolean guardado = true;
	private static boolean guardadoprimeravez = false;
	private static JFileChooser jf = new JFileChooser();
	private static FileNameExtensionFilter filter = new FileNameExtensionFilter(
	        "Objetos (.obj)", "obj");
	private static int opcion;
	private static int respuesta;
	private final static String message = "Error, no se ha podido hacer la operación con el archivo";
	
	/**
	 * Comprueba que se guarde el concesionario
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	static void guardar() throws FileNotFoundException, IOException{
		if(guardadoprimeravez == false){
			guardarComo();
		}
		else{
			try {
				Fichero.guardar(file,concesionario);
				JOptionPane.showMessageDialog(null, "Se ha guardado exitosamente");
			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, message);
			}
		}
		setModificado(false);

	}
	
	/**
	 * Comprueba el método guardarComo()
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * 
	 */
	static void guardarComo() throws FileNotFoundException, IOException {
		jf.setFileFilter(filter);
		opcion = jf.showSaveDialog(null);
		if (opcion == JFileChooser.APPROVE_OPTION){
			file = jf.getSelectedFile();
			if (file.exists()){
				respuesta = JOptionPane.showConfirmDialog(null, "¿Desea sobreescribir el archivo?",
						"Sobreescribir", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null);
				if(respuesta == JOptionPane.YES_OPTION){
					Fichero.guardar(file, concesionario);
					setGuardadoprimeravez(true);
					setModificado(false);
					setGuardado(true);
				}
				else{
					setGuardado(false);
					return;
				}
			}else{
				Fichero.guardar(file, concesionario);
				setGuardado(true);
				setModificado(false);
				setGuardadoprimeravez(true);
			}
			frame.setTitle(file.getName());
		}else{
			setModificado(true);
			setGuardado(false);
			return;
		}
	}
	
	public static void comprobarGuardadoNuevo() throws FileNotFoundException, IOException {
		if (modificado == true || guardado == false){
			file = null;
			respuesta = JOptionPane.showConfirmDialog(null, "¿Deseas guardar los cambios realizados?", 
					"Concesionario", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null);
			if(respuesta == JOptionPane.YES_OPTION){
				guardarComo();
				concesionario = new Concesionario();
				setGuardado(true);
				setModificado(false);
			}
			if (respuesta == JOptionPane.NO_OPTION){
				concesionario = new Concesionario();
				file = new File("SinTitulo.obj");
				frame.setTitle(file.getName());
				setModificado(false);
				setGuardado(true);
			}else{
				return;
			}
			frame.setTitle(file.getName());
		}else{
			concesionario = new Concesionario();
			file = new File("SinTitulo.obj");
			frame.setTitle(file.getName());
		}
		setGuardadoprimeravez(false);
	}
	
	static void comprobarGuardadoAbrir() throws ClassNotFoundException, FileNotFoundException, IOException {
		file = null;
		if (modificado == true || guardado == false){
			respuesta = JOptionPane.showConfirmDialog(null, "¿Deseas guardar los cambios realizados?", 
					"Concesionario", JOptionPane.YES_NO_CANCEL_OPTION);
			if(respuesta == JOptionPane.YES_OPTION){
				guardarComo();
				setModificado(false);
				setGuardado(true);
				abrir();
			}
			if (respuesta == JOptionPane.NO_OPTION){
				file = null;
				setModificado(false);
				setGuardado(true);
				abrir();
			}
			else
				return;
			frame.setTitle(file.getName());
		}else {
			abrir();
		}
		setGuardado(true);
		
	}
	
	static void abrir() throws ClassNotFoundException {
		jf.setFileFilter(filter);
		opcion = jf.showOpenDialog(null);
		if (opcion == JFileChooser.APPROVE_OPTION){
			file = jf.getSelectedFile();
			try{
				concesionario = (Concesionario) Fichero.abrir(file);
				frame.setTitle(file.getName());
				setGuardado(true);
				setModificado(false);
				setGuardadoprimeravez(true);
			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, message);
			}
		}else
			return;
		setModificado(false);
		setGuardado(true);
		setGuardadoprimeravez(true);
	}
	
	static void salir() throws FileNotFoundException, IOException {
		if(modificado == true){
			int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea guardar los cambios antes de salir?",
					"¿Deseas salir?", JOptionPane.YES_NO_CANCEL_OPTION);
			if(respuesta == JOptionPane.CANCEL_OPTION){
				return;
			}
			if(respuesta == JOptionPane.YES_OPTION){
				if (guardado == true){
					Fichero.guardar(file, concesionario);
					setGuardado(true);
					System.exit(0);
				}
				else{
					guardarComo();
					if (guardado == true)
						System.exit(0);
					else return;
				}
			}else{
				System.exit(0);
			}
		}else
			System.exit(0);
	}
	
	static void alta(Concesionario concesionario) {
		alta = new Annadir(concesionario);
		alta.setVisible(true);
	}
	
	static void baja(Concesionario concesionario) {
		if (concesionario.size() == 0) {
			JOptionPane.showMessageDialog(frame.getContentPane(),
					"No hay coches en el concesionario.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		baja = new Eliminar(concesionario);
		baja.setVisible(true);
	}

	static void setGuardadoprimeravez(boolean b) {
		Generar.guardadoprimeravez = b;
	}
	
	static void setGuardado(boolean b) {
		guardado = b;
	}

	static void setModificado(boolean b){
		modificado = b;
	}
	
}
