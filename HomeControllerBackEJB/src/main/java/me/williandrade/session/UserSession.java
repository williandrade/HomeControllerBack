package me.williandrade.session;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import me.williandrade.dao.UserDAO;
import me.williandrade.dto.UserDTO;
import me.williandrade.entity.User;
import me.williandrade.mapper.UserMapper;

@Stateless
@LocalBean
public class UserSession {

	@EJB
	private UserDAO userDAO;

	@Inject
	private UserMapper userMapper;

	public List<UserDTO> findByFamilyId(Integer id) {
		Set<User> users = userDAO.findByFamilyId(id);
		List<UserDTO> usersDTO = new ArrayList<>(userMapper.usersToUserDTOs(users));

		return usersDTO;
	}

	public List<UserDTO> findAll() {
		Set<User> users = userDAO.findAll();
		List<UserDTO> usersDTO = new ArrayList<>(userMapper.usersToUserDTOs(users));

		return usersDTO;
	}

}
