package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistence.FileHandler;
/**
 * 
 * @author MiguelRamírez
 *
 */
public class ContestantDAOImplements implements ContestantDAO{
	/**
	 * Array declaration of ContestantDTO, allows store objects in the memory
	 */
	private ArrayList<ContestantDTO> list;
	/**
	 * Constructor method
	 */
	public ContestantDAOImplements() {
		list = new ArrayList<ContestantDTO>();
		loadSerializable();
	}
	/**
	 * method for write object attributes in memory
	 */
	public void writeFile() {
		String content = listContestant();
		FileHandler.writeFile("Data.csv", content);
	}
	/**
	 * method for load object attributes in a serializable file
	 */
	@SuppressWarnings("unchecked")
	public void loadSerializable() {
		Object aux = FileHandler.readSerializable("Dataserializable.31n");
		list = (ArrayList<ContestantDTO>)aux;
	}
	/**
	 * method for load object attributes in program
	 */
	public void loadFile() {
		String content = FileHandler.loadFile("Data.csv");
		String[] lines = content.split("\n");
		for (String s : lines) {
			if(s.equals("")) 
				continue;
				String[] columns = s.split(",");
				list.add(new ContestantDTO(columns[0], columns[1], 
						Integer.parseInt(columns[2]), columns[3], columns[4]));
		}
	}
	/**
	 * method which creates a new object contestant
	 */
	@Override
	public void addNewContestant(String name,String surname,int age, String id, String post) {
				list.add(new ContestantDTO(name, surname, age, id, post));
				writeFile();
				FileHandler.writeSerializable(list, "Dataserializable.31n");
	}
	/**
	 * method which sets an object contestant
	 */
	@Override
	public void setContestant(String id, String name,String surname,int age, String post) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(id)) {
				list.get(i).setName(name);
				list.get(i).setSurname(surname);
				list.get(i).setAge(age);
				list.get(i).setPost(post);
				writeFile();
			}
		}
	}
	/**
	 * method which deletes an object contestant
	 */
	@Override
	public void deleteContestant(String id) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(id)) {
				list.remove(i);
				writeFile();
			}
		}
	}
	/**
	 * method which lists objects contestant
	 */
	@Override
	public String listContestant() {
		StringBuilder sb = new StringBuilder();
		for (ContestantDTO c : list) {
			sb.append(c.toString());
		}
		return sb.toString();
	}
	/**
	 * method which lists one object contestant
	 */
	@Override
	public String listOneContestant(String id) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(id)) {
				sb.append(list.get(i).toString());
			}
		}
		return sb.toString();
	}
	
	public boolean find(String id) {
		boolean found = false;
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(id)) {
				found = true;
			}
		}
		return found;
	}
}
