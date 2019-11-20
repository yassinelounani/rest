package com.excilys.formation.rest.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.excilys.formation.rest.models.Ingredient;

@Repository
public class IngredientRepository {
	
	private static final String DELETE_FROM_INGREDIENT = "delete from ingredient";
	private static final String FROM_INGREDIENT = "from Ingredient";
	
	@PersistenceContext
	EntityManager entityManager;
	
	public IngredientRepository(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	public List<Ingredient> getAllIngredients() {
		Session session = entityManager.unwrap(Session.class);
		Query<Ingredient> query = session.createQuery(FROM_INGREDIENT, Ingredient.class);
		return query.getResultList();
	}

	public Ingredient getIngredientById(long id) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(Ingredient.class, id);
	}

	public void createIngredient(Ingredient ingredient) {
		Session session = entityManager.unwrap(Session.class);
		session.save(ingredient);
	}

	public void updateIngredient(Ingredient ingredient) {
		Session session = entityManager.unwrap(Session.class);
		session.update(ingredient);
	}

	public void deleteIngredient(long id) {
		Session session = entityManager.unwrap(Session.class);
		Ingredient ingredient = getIngredientById(id);
		session.delete(ingredient);
	}

	public int deleteAll() {
		Session session = entityManager.unwrap(Session.class);
		Query<Ingredient> query = session.createQuery(DELETE_FROM_INGREDIENT, Ingredient.class);
		return query.executeUpdate();
	}

}
