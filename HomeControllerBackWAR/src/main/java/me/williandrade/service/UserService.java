package me.williandrade.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import me.williandrade.dto.ResponseDTO;
import me.williandrade.handler.UserRequestHandler;
import me.williandrade.session.UserSession;
import me.williandrade.util.RestReponseUtil;

@Stateless
@Path("/user")
public class UserService {

	@EJB
	private RestReponseUtil restReponseUtil;

	@EJB
	private UserSession userSession;

	@Inject
	private UserRequestHandler userRequestHandler;

	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findByName() {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(userSession.test());
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}
}
