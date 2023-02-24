package co.edu.unbosque.model.persistence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileHandler {
	
	 private static FileOutputStream fos;
	 private static ObjectOutputStream oos;

	 private static FileInputStream fis;
	 private static ObjectInputStream ois;
	 
	 public static Object readSerializable(String filename) {
			try {
				fis = new FileInputStream("src/co/edu/unbosque/model/persistence/" + filename);
			} catch (FileNotFoundException e) {
				System.out.println("Error on find file (serializable-read)");
				System.out.println(e.getMessage());
			}
			try {
				ois = new ObjectInputStream(fis);
			} catch (IOException e) {
				System.out.println("Error on reading (serializable - read)");
				System.out.println(e.getMessage());
			}
			Object aux = null;
			try {
				aux = ois.readObject();
			} catch (ClassNotFoundException e) {
				System.out.println("Error on integrity (Serializable - read)");
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println("Error on permissions (Serializable - read)");
				System.out.println(e.getMessage());
			}
			return aux;
		}

		public static void writeSerializable(Object o, String filename) {
			// buscar el archivo
			try {
				fos = new FileOutputStream("src/co/edu/unbosque/model/persistence/" + filename);
			} catch (FileNotFoundException e) {
				System.out.println("File not found (serializable)");
				System.out.println(e.getMessage());
			}

			// Cogiendo archivo y seleccionandolo para escritura
			try {
				oos = new ObjectOutputStream(fos);
				// escribir el objeto
				oos.writeObject(o);
			} catch (IOException e) {
				System.out.println("Error on writing (serializable)");
				System.out.println(e.getMessage());
			}
			try {
				oos.close();
				fos.close();
			} catch (IOException e) {
				System.out.println("Error on closing file (Serializable)");
				System.out.println(e.getMessage());
			}

		}
}
