/**
 * 
 */
package concesionario;
//Comentario de prueba
//Roberto
import java.io.Serializable;
import java.util.regex.Pattern;

/**
 * Un coche tendr� las siguientes caracter�sticas:
 * <ul>
 * <li>Color. Se limitar�n los colores a tres: plata, rojo y azul. Para
 * solicitar el color al dar de alta al coche se implementar� un m�todo
 * pedirColor que mediante la gesti�n de un men�, devolver� el color indicado.</li>
 * <li>Modelo. Se limitar�n los modelos de coches a siete: C�rdoba (marca Seat),
 * Toledo (marca Seat), Ibiza (marca Seat), Serie 1 (marca BMW), Serie 2 (marca
 * BMW), Serie 3 (marca BMW) y Serie 5 (marca BMW). Para solicitar el modelo al
 * dar de alta al coche podr� implementarse un m�todo pedirModelo que mediante
 * la gesti�n de un men�, devolver� el modelo indicado.</li>
 * <li>Matr�cula (�nica por coche). El formato de las matr�culas ser� el nuevo:
 * combinaci�n de cuatro n�meros (de 0000 a 9999) y tres letras, comenzando por
 * BBB y terminando por ZZZ, excluyendo vocales, la LL, la � y la Q.</li>
 * </ul>
 * 
 * @author Javier Ben�tez del Pozo
 * @version 1.0
 */
public class Coche implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Matr�cula del coche
	 */
	private String matricula;
	
	/**
	 * Color del coche
	 */
	private Color color;
	
	/**
	 * Modelo del coche
	 */
	private Modelo modelo;
	
	/**
	 * Patr�n para una matr�cula v�lida
	 */
	static final private Pattern patternMatricula = Pattern
			.compile("^\\d{4}[ -]?[[B-Z]&&[^QEIOU]]{3}$");

	/**
	 * Construye un nuevo coche de matr�cula, color y modelo especificado
	 * 
	 * @param matricula
	 *            Representa la matr�cula del nuevo coche
	 * @param color
	 *            Representa el color del nuevo coche
	 * @param modelo
	 *            Representa el modelo del nuevo coche
	 */
	private Coche(String matricula, Color color, Modelo modelo){
		super();
		setMatricula(matricula);
		setColor(color);
		setModelo(modelo);
	}

	/**
	 * Construye un nuevo coche de matr�cula especificada
	 * 
	 * @param matricula
	 *            Representa la matr�cula del nuevo coche
	 */
	private Coche(String matricula) {
		setMatricula(matricula);
	}

	/**
	 * Instancia un objeto de clase coche de matr�cula, color y modelo
	 * especificado
	 * 
	 * @param matricula
	 *            Representa la matr�cula del nuevo coche
	 * @param color
	 *            Representa el color del nuevo coche
	 * @param modelo
	 *            Representa el modelo del nuevo coche
	 * @return Objeto de clase coche. null si la matr�cula, el color o el modelo
	 *         no son v�lidos
	 */
	static Coche instanciarCoche(String matricula, Color color, Modelo modelo) {
		try{
			if (esValida(matricula) && color != null && modelo != null)
				return new Coche(matricula, color, modelo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Instancia un objeto de clase coche de matr�cula especificada
	 * 
	 * @param matricula
	 *            Representa la matr�cula del nuevo coche
	 * @return Objeto de clase coche. null si la matr�cula no es v�lida
	 */
	static Coche instanciarCoche(String matricula) {
		try{
		if (esValida(matricula))
			return new Coche(matricula);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Comprueba si la matr�cula del coche es v�lida o no
	 * 
	 * @param matricula
	 *            Representa la matr�cula a validar
	 * @return true si la matr�cula es v�lida, false si la matr�cula no es
	 *         v�lida
	 */
	public static boolean esValida(String matricula) {
		return patternMatricula.matcher(matricula).matches();
	}

	/**
	 * Modifica la matr�cula del coche
	 * 
	 * @param matricula
	 *            Representa la nueva matr�cula del coche
	 */
	private void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/**
	 * Devuelve el color del coche
	 * 
	 * @return Color del coche
	 */
	public Color getColor() {
		return color;
	}
	
	public Modelo getModelo() {
		return modelo;
	}
	
	public String getMatricula() {
		return matricula;
	}

	/**
	 * Modifica el color del coche
	 * 
	 * @param color
	 *            Representa el nuevo color del coche
	 */
	private void setColor(Color color) {
		this.color = color;
	}

	/**
	 * Modifica el modelo del coche
	 * 
	 * @param modelo
	 *            Representa el nuevo modelo del coche
	 */
	private void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\nCoche [matricula=" + matricula + ", color=" + color
				+ ", modelo=" + modelo + "]";
	}

}