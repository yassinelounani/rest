package com.excilys.formation.rest.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.excilys.formation.rest.models.Recipe;

public class RecipeRepository {

	private static final String DELETE_FROM_RECIPE = "delete from recipe";
	private static final String FROM_RECIPE = "from recipe";

	@PersistenceContext
	EntityManager entityManager;

	public RecipeRepository(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	public List<Recipe> getAllRecipes() {
		Session session = entityManager.unwrap(Session.class);
		Query<Recipe> query = session.createQuery(FROM_RECIPE, Recipe.class);
		return query.getResultList();
	}

	public Recipe getRecipeById(long id) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(Recipe.class, id);
	}

	public void createRecipe(Recipe recipe) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(recipe);
	}

	public void updateRecipe(Recipe recipe) {
		Session session = entityManager.unwrap(Session.class);
		session.update(recipe);
	}

	public void deleteRecipeById(long id) {
		Session session = entityManager.unwrap(Session.class);
		Recipe recipe = getRecipeById(id);
		session.delete(recipe);
	}

	public int deleteAllRecipes() {
		Session session = entityManager.unwrap(Session.class);
		Query<Recipe> query = session.createQuery(DELETE_FROM_RECIPE, Recipe.class);
		return query.executeUpdate();
	}
}
