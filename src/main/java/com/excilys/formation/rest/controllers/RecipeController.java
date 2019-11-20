package com.excilys.formation.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.excilys.formation.rest.dto.RecipeDto;
import com.excilys.formation.rest.services.RecipeService;


@RestController
public class RecipeController {

	private RecipeService service;
	@Autowired
	public RecipeController(RecipeService service) {
		super();
		this.service = service;
	}

	@GetMapping
	public List<RecipeDto> getAll() {
		return service.getAllRecipes();
	}

	@GetMapping("/{id}")
	public RecipeDto getByID(@PathVariable Long id) {
		return service.getRecipeById(id);
	}

	@PostMapping
	public void create(@RequestBody RecipeDto Recipe) {
		service.createRecipe(Recipe);
	}

	@PutMapping
	public void update(@RequestBody RecipeDto Recipe) {
		service.updateRecipe(Recipe);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		 service.deleteRecipe(id);
	}

	@DeleteMapping
	public void delete() {
		 service.deleteAllRecipes();
	}
}
