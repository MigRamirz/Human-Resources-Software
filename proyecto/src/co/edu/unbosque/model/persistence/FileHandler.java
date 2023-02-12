package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileHandler {
	
	private static File file;
	private static Scanner reader;
	private static PrintWriter writer;

	// Leer un archivo serializado
	private static FileInputStream fis; // archivo
	private static ObjectInputStream ois; // lector

	// Escritura
	private static FileOutputStream fos; // archivo
	private static ObjectOutputStream oos; // escitor

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

	public static String loadFile(String filename) {
		file = new File("src/co/edu/unbosque/model/persistence/" + filename);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("can´t create new file");
				System.out.println(e.getMessage());
			}
		}
		String content = "";
		try {
			reader = new Scanner(file);
			while (reader.hasNext()) {
				content += reader.nextLine() + "\n";
			}
		} catch (FileNotFoundException e) {
			System.out.println("file does not exist");
			e.printStackTrace();
		}
		reader.close();
		return content;

	}

	public static void writeFile(String filename, String content) {
		file = new File("src/co/edu/unbosque/model/persistence/" + filename);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("can´t create new file");
				System.out.println(e.getMessage());
			}
		}
		try {
			writer = new PrintWriter(file);
			writer.print(content);
		} catch (FileNotFoundException e) {
			System.out.println("file does not exist");
			e.printStackTrace();
		}
		writer.close();
	}
	
}
