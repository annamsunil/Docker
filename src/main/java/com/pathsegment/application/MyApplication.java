package com.pathsegment.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/services")
public class MyApplication extends Application {
	private Set<Object> singletons;
	private Set<Class<?>> classes;

	public MyApplication() {
		singletons = new HashSet<Object>();
		classes = new HashSet<Class<?>>();
	}

	public Set<Object> getSingletons() {
		return this.singletons;
	}

	public Set<Class<?>> getClasses() {
		return this.classes;
	}

}
