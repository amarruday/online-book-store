package com.amarruday.onlinebookstore;

import java.util.Iterator;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class RepositoryRestConfig implements RepositoryRestConfigurer {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		// config.exposeIdsFor(<EntityClassNameHere>.class);
		// config.exposeIdsFor(<EntityClassNameHere>.class);
		
		/*
		 * Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
		 * Iterator<?> it = entities.iterator(); while(it.hasNext()) {
		 * config.exposeIdsFor(Class.forName(it.next().getClass())); }
		 */
		config.exposeIdsFor(entityManager.getMetamodel().getEntities().stream()
				.map(Type::getJavaType)
				.toArray(Class[]::new));

	}
}
