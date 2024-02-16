package fecha;

/**
 * Esta clase indica la si la fecha que ha insertado el usuario es correcta
 * 
 * @author rromera
 */
public class Fecha {

	private static final int DIEZ = 10;

	/**
	 * Atributo que recoge el numero que pertence al dia
	 */
	private int numDia;

	/**
	 * Atributo que recoge el numero que pertence al mes
	 */
	private int numMes;

	/**
	 * Atributo que recoge el numero que pertence al anio
	 */
	private int numAño;

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
		this.numDia = dia;
		this.numMes = mes;
		this.numAño = anio;
	}

	/**
	 * Metodo que indica si la fecha es correcta, para ello hace uso de booleanos
	 * que luego devuelve a la clase principal
	 * 
	 * @return Devuelve tres booleanos, cada uno respectivos a dia, mes y anio
	 */
	public boolean fechaCorrecta() {
		boolean diaCorrecto;
		
		boolean mesCorrecto;
		
		boolean anioCorrecto;
		
		anioCorrecto = numAño > 0;
		mesCorrecto = numMes >= 1 && numMes <= 12;
		boolean diaMayor1 = numDia >= 1;
		switch (numMes) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = diaMayor1 && numDia <= 29;
			} else {
				diaCorrecto = diaMayor1 && numDia <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = diaMayor1 && numDia <= 30;
			break;
		default:
			diaCorrecto = diaMayor1 && numDia <= 31;
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
		return numAño % 4 == 0 && numAño % 100 != 0 || numAño % 400 == 0;
	}

	/**
	 * Metodo que suma los numeros de cada atributo para y los suma correctamente
	 */
	public void nextDay() {
		numDia++;
		if (!fechaCorrecta()) {
			numDia = 1;
			numMes++;
			if (!fechaCorrecta()) {
				numMes = 1;
				numAño++;
			}
		}
	}

	/**
	 * Metodo que dibuja el mensaje final corregido
	 */
	public String toString() {

		String imprime = "";

		if (numDia < DIEZ && numMes < DIEZ) {
			imprime = ("0" + numDia + "-0" + numMes + "-" + numAño);
		} else if (numDia < DIEZ && numMes >= DIEZ) {
			imprime = ("0" + numDia + "-" + numMes + "-" + numAño);
		} else if (numDia >= DIEZ && numMes < DIEZ) {
			imprime = (numDia + "-0" + numMes + "-" + numAño);
		} else {
			imprime = (numDia + "-" + numMes + "-" + numAño);
		}
		return imprime;
	}

}
