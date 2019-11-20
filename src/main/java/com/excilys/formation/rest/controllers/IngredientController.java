package com.excilys.formation.rest.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excilys.formation.rest.dto.IngredientDto;
import com.excilys.formation.rest.services.IngredientService;

@RestController
@RequestMapping(value = "/api/v1/ingredients")
public class IngredientController {
	private IngredientService service;

	public IngredientController(IngredientService service) {
		super();
		this.service = service;
	}
	
	@GetMapping
	public List<IngredientDto> getAll() {
		return service.getAllIngredients();
	}

	@GetMapping("/{id}")
	public IngredientDto getByID(@PathVariable Long id) {
		 return service.getIngredientById(id);
	}

	@PostMapping
	public void create(@RequestBody IngredientDto ingredient) {
		service.createIngredient(ingredient);
	}

	@PutMapping
	public void update(@RequestBody IngredientDto ingredient) {
		service.updateIngredient(ingredient);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		 service.deleteIngredient(Long.valueOf(id));
	}

	@DeleteMapping
	public void delete() {
		 service.deleteAllIngredients();
	}
}
