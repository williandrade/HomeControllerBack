package me.williandrade.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/service")
public class HomeControllerConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();

		classes.add(me.williandrade.config.ResponseFilter.class);

		classes.add(me.williandrade.service.UserService.class);

		return classes;
	}
}
