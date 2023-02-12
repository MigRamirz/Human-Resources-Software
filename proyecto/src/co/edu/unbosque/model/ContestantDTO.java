package co.edu.unbosque.model;

import java.io.Serializable;
/**
 * 
 * @author MiguelRamírez
 *
 */
public class ContestantDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * Declaration attribute string type
	 */
	private String name;
	/**
	 * Declaration attribute string type
	 */
	private String surname;
	/**
	 * Declaration attribute integer type
	 */
	private int age;
	/**
	 * Declaration attribute string type
	 */
	private String id;
	/**
	 * Declaration attribute string type
	 */
	private String post;
	/**
	 * 
	 * @param name
	 * @param surname
	 * @param age
	 * @param id
	 * @param post
	 * Constructor method which creates new object contestant
	 */
	public ContestantDTO(String name, String surname, int age, String id, String post) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.id = id;
		this.post = post;
	}
	/**
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @param name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}
	/**
	 * 
	 * @param surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	/**
	 * 
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * 
	 * @param age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * 
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * 
	 * @param id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 
	 * @return the post
	 */
	public String getPost() {
		return post;
	}
	/**
	 * 
	 * @param post to set
	 */
	public void setPost(String post) {
		this.post = post;
	}
	/**
	 * toString method
	 * @return attribute values to the object contestant
	 */
	@Override
	public String toString() {
		return "Contestant \n"
				+ "Name: " + name + "\n"
				+ "Surname: " + surname + "\n"
				+ "Age: " + age + "\n"
				+ "Id: " + id + "\n"
				+ "Post: "+ post + "\n"
				+ "--------------------------"+"\n";
	}
	
}
