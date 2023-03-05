package co.edu.unbosque.controller;

/**
 * Principal Class
 * @author MiguelRamírez
 *
 */
public class AplMain {
	
	/**
	 * Principal method which call object Controller type.
	 * @param args Arrangement which allows memory separation with the program.
	 */
	public static void main(String[] args) {
		Controller c = new Controller();
		Server s = new Server(9000);
		s.start();
	}
}
