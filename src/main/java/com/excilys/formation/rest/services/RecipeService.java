package com.excilys.formation.rest.services;

import static com.excilys.formation.rest.mapper.Mapper.mapAllReciepes;
import static com.excilys.formation.rest.mapper.Mapper.mapToRecipe;
import static com.excilys.formation.rest.mapper.Mapper.mapToRecipeDto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.excilys.formation.rest.dto.RecipeDto;
import com.excilys.formation.rest.models.Recipe;
import com.excilys.formation.rest.repositories.RecipeRepository;

public class RecipeService {

	private RecipeRepository repository;

	@Autowired
	public RecipeService(RecipeRepository repository) {
		super();
		this.repository = repository;
	}

	public List<RecipeDto> getAllRecipes() {
		List<Recipe> Recipes = repository.getAllRecipes();
		return mapAllReciepes(Recipes);
	}

	public RecipeDto getRecipeById(long id) {
		Recipe Recipe = repository.getRecipeById(id);
		return mapToRecipeDto(Recipe);
	}

	public void createRecipe(RecipeDto RecipeDto) {
		Recipe Recipe = mapToRecipe(RecipeDto);
		repository.createRecipe(Recipe);
	}

	public void updateRecipe(RecipeDto RecipeDto) {
		Recipe Recipe = mapToRecipe(RecipeDto);
		repository.updateRecipe(Recipe);
	}

	public void deleteRecipe(long id) {
		repository.deleteRecipeById(id);
	}

	public int deleteAllRecipes() {
		return repository.deleteAllRecipes();
	}
}
