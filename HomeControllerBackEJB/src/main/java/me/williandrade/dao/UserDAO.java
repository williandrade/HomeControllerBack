package me.williandrade.dao;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import me.williandrade.entity.User;

@Stateless
@LocalBean
public class UserDAO extends GenericDAO<User> {

	public UserDAO() {
		super(User.class);
	}

	public Set<User> findByFamilyId(Integer id) {
		String hql = "Select u from User u where u.familySet.id = :id";
		Query query = this.getEm().createQuery(hql);

		query.setParameter("id", id);
		return new HashSet<User>(query.getResultList());
	}

}
