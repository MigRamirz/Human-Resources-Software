package co.edu.unbosque.model;
/**
 * 
 * @author MiguelRamírez
 *
 */
public interface ContestantDAO {
	
	
	/**
	 * 
	 * @param name
	 * @param surname
	 * @param age
	 * @param id
	 * @param post
	 */
	/**
	 * method which allows create new contestant
	 * @return 
	 */
	public void addNewContestant(String name,String surname,
			int age, String id, String post);
	/**
	 * method which allows set a contestant
	 */
	public void setContestant(String id, String name,String surname,
			int age, String post);
	/**
	 * method which allows delete a contestant
	 */
	public void deleteContestant(String id);
	/**
	 * method which allows list contestants
	 */
	public String listContestant();
	/**
	 * method which allows list one contestant
	 */
	public String listOneContestant(String id);
	
}
