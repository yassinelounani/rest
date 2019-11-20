package com.excilys.formation.rest.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.excilys.formation.rest.dto.IngredientDto;
import com.excilys.formation.rest.dto.RecipeDto;
import com.excilys.formation.rest.models.Ingredient;
import com.excilys.formation.rest.models.Recipe;

public class Mapper {
	private static ModelMapper modelMapper;
	
	static {
		modelMapper = new ModelMapper();
	}

	public static RecipeDto mapToRecipeDto(Recipe receipe) {
		return modelMapper.map(receipe, RecipeDto.class);
	}

	public static IngredientDto mapToIngredientDto(Ingredient receipe) {
		return modelMapper.map(receipe, IngredientDto.class);
	}
	
	public static Recipe mapToRecipe(RecipeDto receipeDto) {
		return modelMapper.map(receipeDto, Recipe.class);
	}

	public static Ingredient mapToIngredient(IngredientDto ingredientDto) {
		return modelMapper.map(ingredientDto, Ingredient.class);
	}

	public static List<IngredientDto> mapAllIngredients(List<Ingredient> entityList) {
        return entityList.stream()
                .map(entity -> mapToIngredientDto(entity))
                .collect(Collectors.toList());
	}

	public static List<RecipeDto> mapAllReciepes(List<Recipe> entityList) {
        return entityList.stream()
                .map(entity -> mapToRecipeDto(entity))
                .collect(Collectors.toList());
	}
	
}
