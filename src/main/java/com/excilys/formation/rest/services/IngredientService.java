package com.excilys.formation.rest.services;

import static com.excilys.formation.rest.mapper.Mapper.mapAllIngredients;
import static com.excilys.formation.rest.mapper.Mapper.mapToIngredient;
import static com.excilys.formation.rest.mapper.Mapper.mapToIngredientDto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.excilys.formation.rest.dto.IngredientDto;
import com.excilys.formation.rest.models.Ingredient;
import com.excilys.formation.rest.repositories.IngredientRepository;
@Service
@Transactional
public class IngredientService {

	private IngredientRepository repository;
	@Autowired
	public IngredientService(IngredientRepository repository) {
		super();
		this.repository = repository;
	}

	public List<IngredientDto> getAllIngredients() {
		List<Ingredient> ingredients = repository.getAllIngredients();
		return mapAllIngredients(ingredients);
	}

	public IngredientDto getIngredientById(long id) {
		Ingredient ingredient = repository.getIngredientById(id);
		return mapToIngredientDto(ingredient); 
	}

	public void createIngredient(IngredientDto ingredientDto) {
		Ingredient ingredient = mapToIngredient(ingredientDto);
		repository.createIngredient(ingredient);
	}

	public void updateIngredient(IngredientDto ingredientDto) {
		Ingredient ingredient = mapToIngredient(ingredientDto);
		repository.updateIngredient(ingredient);
	}

	public void deleteIngredient(long id) {
		repository.deleteIngredient(id);
	}

	public int deleteAllIngredients() {
		return repository.deleteAll();
	}
	
}
