package fr.scholanova.group.java.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.scholanova.group.java.entities.User;
import lombok.Setter;

@Repository("userDao")
@Setter
public class UserDaoImpl implements UserDao {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * {@inheritDoc}
	 */
	public void save(User user) {
		entityManager.persist(user);
	}

	/**
	 * {@inheritDoc}
	 */
	public void delete(User user) {
		entityManager.remove(user);
	}

	/**
	 * {@inheritDoc}
	 */
	public User read(Integer id) {
		return entityManager.find(User.class, id);
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<User> findByFirstName(String first) {
		return findBy("firstName", first);
	}

	/**
	 * {@inheritDoc}}
	 */
	public Collection<User> get() {
		return entityManager.createQuery("SELECT u FROM User u").getResultList();
	}

	/**
	 * {@inheritDoc}}
	 */
	public Collection<User> findByLastName(String lastName) {
		return findBy("lastName", lastName);
	}
	
	private Collection<User> findBy(String param, String value) {
		return entityManager.createQuery("SELECT u FROM User u WHERE u." + param + "= :" + param)
				.setParameter(param, value).getResultList();
	}

}
