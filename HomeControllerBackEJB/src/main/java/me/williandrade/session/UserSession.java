package me.williandrade.session;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import me.williandrade.dto.TestDTO;

@Stateless
@LocalBean
public class UserSession {

	public TestDTO test() {

		return new TestDTO("Testando");
	}

}
