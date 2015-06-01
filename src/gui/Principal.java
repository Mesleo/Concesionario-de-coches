package gui;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import concesionario.Concesionario;
import ficheros.Fichero;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Clase Principal desde donde se ejecutan todas las ventanas gráficas
 * 
 * @author Javier Benítez del Pozo
 *
 */
public class Principal {

	protected static JFrame frame;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnCoche;
	private JMenu mnBuscar;
	private JMenu mnAyuda;
	protected static Concesionario concesionario = new Concesionario();
	private Mostrar mostrar;
	private ElegirColor elegirColor;
	private MostrarPorMatricula mostrarPorMatricula;
	private About about;
	private Ayuda ayuda;
	private TotalCoches tc;
	protected static final Component parent = null;
	protected static File file = new File("SinTitulo.obj");
	private final static String message = "Error, no se ha podido hacer la operación con el archivo";
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, message);
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					Generar.salir();
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(null, message);
					e1.printStackTrace();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, message);
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setResizable(false);
		frame.setTitle(file.getName());
		frame.setIconImage(new ImageIcon("src/imagenes/car.png").getImage()); 
		
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmNuevoConcesionario = new JMenuItem("Nuevo");
		mntmNuevoConcesionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Generar.comprobarGuardadoNuevo();
					file = new File("SinTitulo.obj");
					frame.setTitle(file.getName());
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(null, message);
					e.printStackTrace();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, message);
					e.printStackTrace();
				}
			}
		});
		mntmNuevoConcesionario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmNuevoConcesionario);
		
		final JMenuItem mntmAbrirConcesionario = new JMenuItem("Abrir...");
		mntmAbrirConcesionario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mntmAbrirConcesionario.addActionListener(new ActionListener() {
			 public void actionPerformed (ActionEvent e) {
				try {
					try {
						Generar.comprobarGuardadoAbrir();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, message);
					} catch (IOException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, message);
					}
				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(null, message);
				}
			 }
		});

		
		mnArchivo.add(mntmAbrirConcesionario);
		
		mnArchivo.addSeparator();
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Generar.guardar();
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(null, message);
					e.printStackTrace();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, message);
					e.printStackTrace();
				}
			}
		});
		
		
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmGuardar);
		
		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como...");
		mntmGuardarComo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK));
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Generar.guardarComo();
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(null, message);
					e.printStackTrace();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, message);
					e.printStackTrace();
				}
			}
		}
	);
		mnArchivo.add(mntmGuardarComo);
		
		mnArchivo.addSeparator();
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Generar.salir();
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(null, message);
					e.printStackTrace();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, message);
					e.printStackTrace();
				}
			}
		});
		mnArchivo.add(mntmSalir);
		
		mnCoche = new JMenu("Concesionario");
		menuBar.add(mnCoche);
		
		JMenuItem mntmAlta = new JMenuItem("Alta coche");
		mntmAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Generar.alta(concesionario);
			}
		});
		mntmAlta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_MASK));
		mnCoche.add(mntmAlta);
		
		JMenuItem mntmBaja = new JMenuItem("Baja coche");
		mntmBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Generar.baja(concesionario);
			}
		});
		mntmBaja.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.ALT_MASK));
		mnCoche.add(mntmBaja);
		
		mnCoche.addSeparator();
		
		JMenuItem mntmMostrarConcesionario = new JMenuItem("Mostrar concesionario");
		mntmMostrarConcesionario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_MASK));
		mntmMostrarConcesionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrar();
			}
		});
		mnCoche.add(mntmMostrarConcesionario);
		
		JMenuItem mntmMostrarTotalCoches = new JMenuItem("Mostrar total coches");
		mntmMostrarTotalCoches.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostarTotal();
			}
		});
		mntmMostrarTotalCoches.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.ALT_MASK));
		mnCoche.add(mntmMostrarTotalCoches);
		
		mnBuscar = new JMenu("Buscar");
		menuBar.add(mnBuscar);
		
		JMenuItem mntmCochePorMatricula = new JMenuItem("Por matr\u00EDcula...");
		mntmCochePorMatricula.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_GRAPH_MASK));
		mntmCochePorMatricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPorMatricula();
			}
		});
		mnBuscar.add(mntmCochePorMatricula);
		
		JMenuItem mntmCochePorColor = new JMenuItem("Por color...");
		mntmCochePorColor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_GRAPH_MASK));
		mntmCochePorColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPorColor();
			}
		});
		mnBuscar.add(mntmCochePorColor);
		
		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		mntmAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ayuda = new Ayuda();
				ayuda.setVisible(true);
			}
		});
		mntmAyuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnAyuda.add(mntmAyuda);
		
		JMenuItem mntmSobreConcesionario = new JMenuItem("Sobre concesionario");
		mntmSobreConcesionario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mntmSobreConcesionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				about = new About();
				about.setVisible(true);
			}
		});
		mnAyuda.add(mntmSobreConcesionario);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/SEAT3.png")));
		lblNewLabel.setBounds(10, 86, 230, 153);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/BMW3.png")));
		lblNewLabel_1.setBounds(195, 0, 249, 130);
		frame.getContentPane().add(lblNewLabel_1);
		
	}

	
	private void mostrar() {
		if (concesionario.size() == 0) {
			JOptionPane.showMessageDialog(frame.getContentPane(),
					"No hay coches en el concesionario.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}else{
			mostrar = new Mostrar(concesionario);
			mostrar.setVisible(true);
		}
	}

	private void mostrarPorColor() {
		if (concesionario.size() == 0) {
			JOptionPane.showMessageDialog(frame.getContentPane(),
					"No hay coches en el concesionario.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		elegirColor = new ElegirColor(concesionario);
		elegirColor.setVisible(true);
	}
	
	private void mostrarPorMatricula() {
		if (concesionario.size() == 0) {
			JOptionPane.showMessageDialog(frame.getContentPane(),
					"No hay coches en el concesionario.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		mostrarPorMatricula = new MostrarPorMatricula(concesionario);
		mostrarPorMatricula.setVisible(true);
	}
	
	private void mostarTotal() {
		tc = new TotalCoches(concesionario);
		tc.setVisible(true);
	}

}
		