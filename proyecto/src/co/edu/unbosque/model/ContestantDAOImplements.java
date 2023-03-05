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
	
	@SuppressWarnings("unchecked")
	public void loadSerializable() {
		Object aux = FileHandler.readSerializable("Data.mrx");
		list = (ArrayList<ContestantDTO>)aux;
	}
	
	/**
	 * method which creates a new object contestant
	 */
	@Override
	public void addNewContestant(String name,String surname,int age, String id, String post) {
			list.add(new ContestantDTO(name, surname, age, id, post));
			FileHandler.writeSerializable(list, "Data.mrx");
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
			}
		}
		FileHandler.writeSerializable(list, "Data.mrx");
	}
	/**
	 * method which deletes an object contestant
	 */
	@Override
	public void deleteContestant(String id) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(id)) {
				list.remove(i);
			}
		}
		FileHandler.writeSerializable(list, "Data.mrx");
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
	
	public ArrayList<ContestantDTO>list(){
		return list;
	}
}
