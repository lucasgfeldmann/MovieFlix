package br.com.dnos.MovieFlix.controller;

import br.com.dnos.MovieFlix.controller.request.CategoryRequest;
import br.com.dnos.MovieFlix.controller.response.CategoryResponse;
import br.com.dnos.MovieFlix.mapper.CategoryMapper;
import br.com.dnos.MovieFlix.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movieflix/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        return ResponseEntity.ok(categoryService.findAll().stream().map(CategoryMapper::toCategoryResponse).toList());
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> saveCategory(@RequestBody CategoryRequest category) {
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryMapper.toCategoryResponse(categoryService.saveCategory(CategoryMapper.toCategory(category))));
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoryResponse> getByCategoryId(@PathVariable Long id) {
        return categoryService.findById(id).map(category -> ResponseEntity.ok().body(CategoryMapper.toCategoryResponse(category))).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteByCategoryId(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
