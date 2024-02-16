package fecha;

/**
 * Esta clase indica la si la fecha que ha insertado el usuario es correcta
 * 
 * @author rromera
 */
public class Fecha {

	/**
	 * Atributo que recoge el numero que pertence al dia
	 */
	private int d;

	/**
	 * Atributo que recoge el numero que pertence al mes
	 */
	private int m;

	/**
	 * Atributo que recoge el numero que pertence al anio
	 */
	private int a;

	/**
	 * Constructor que limpia los atributos
	 */
	public Fecha() {

	}

	/**
	 * Constructor que recibe las variables de otra clase y se iguala los atributos
	 * a estos
	 * 
	 * @param dia  Numero introducido el usuario que indica el dia
	 * @param mes  Numero introducido el usuario que indica el mes
	 * @param anio Numero introducido el usuario que indica el año
	 */
	public Fecha(int dia, int mes, int anio) {
		this.d = dia;
		this.m = mes;
		this.a = anio;
	}

	/**
	 * Metodo que indica si la fecha es correcta, para ello hace uso de booleanos
	 * que luego devuelve a la clase principal
	 * 
	 * @return Devuelve tres booleanos, cada uno respectivos a dia, mes y anio
	 */
	public boolean fechaCorrecta() {
		boolean diaCorrecto, mesCorrecto, anioCorrecto;
		anioCorrecto = a > 0;
		mesCorrecto = m >= 1 && m <= 12;
		switch (m) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = d >= 1 && d <= 29;
			} else {
				diaCorrecto = d >= 1 && d <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = d >= 1 && d <= 30;
			break;
		default:
			diaCorrecto = d >= 1 && d <= 31;
		}
		return diaCorrecto && mesCorrecto && anioCorrecto;
	}

	/**
	 * Metodo que, mediante calculos, indica si el año que ha indicado el usuario es
	 * bisiesto
	 * 
	 * @return Devuelve un booleano que indica si es bisiesto o no
	 */
	private boolean esBisiesto() {
		boolean esBisiesto = (a % 4 == 0 && a % 100 != 0 || a % 400 == 0);
		return esBisiesto;
	}

	/**
	 * Metodo que suma los numeros de cada atributo para y los suma correctamente
	 */
	public void diaSiguiente() {
		d++;
		if (!fechaCorrecta()) {
			d = 1;
			m++;
			if (!fechaCorrecta()) {
				m = 1;
				a++;
			}
		}
	}

	/**
	 * Metodo que dibuja el mensaje final corregido
	 */
	public String toString() {
		if (d < 10 && m < 10) {
			return "0" + d + "-0" + m + "-" + a;
		} else if (d < 10 && m >= 10) {
			return "0" + d + "-" + m + "-" + a;
		} else if (d >= 10 && m < 10) {
			return d + "-0" + m + "-" + a;
		} else {
			return d + "-" + m + "-" + a;
		}
	}

}
