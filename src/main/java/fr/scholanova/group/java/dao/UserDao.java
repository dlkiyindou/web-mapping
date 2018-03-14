package fr.scholanova.group.java.dao;

import java.util.Collection;

import fr.scholanova.group.java.entities.User;

public interface UserDao {
	/**
	 * 
	 * @param user
	 */
	public void save(User user);
	
	/**
	 * 
	 * @param user
	 */
	public void delete(User user);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public User read(Integer id);
	
	/**
	 * 
	 * @param first
	 * @return
	 */
	public Collection<User> findByFirstName(String first);

	/**
	 * 
	 * @return
	 */
	public Collection<User> get();

	/**
	 * 
	 * @param lastName
	 * @return
	 */
	public Collection<User> findByLastName(String lastName);
}
