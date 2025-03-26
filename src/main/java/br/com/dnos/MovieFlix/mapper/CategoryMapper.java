package br.com.dnos.MovieFlix.mapper;

import br.com.dnos.MovieFlix.controller.request.CategoryRequest;
import br.com.dnos.MovieFlix.controller.response.CategoryResponse;
import br.com.dnos.MovieFlix.entity.Category;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {
    public static Category toCategory(CategoryRequest categoryRequest) {
        return Category.builder().name(categoryRequest.name()).build();
    }

    public static CategoryResponse toCategoryResponse(Category category) {
        return CategoryResponse.builder().id(category.getId()).name(category.getName()).build();
    }
}
