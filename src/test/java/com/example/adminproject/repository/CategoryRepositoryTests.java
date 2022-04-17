package com.example.adminproject.repository;

import com.example.adminproject.AdminProjectApplicationTests;
import com.example.adminproject.model.entity.Category;
import com.example.adminproject.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class CategoryRepositoryTests extends AdminProjectApplicationTests {

    @Autowired
    private CategoryRepository repository;

    @Test
    public void create() {
        String type = "COMPUTER";
        String title = "컴퓨터";
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";
        LocalDateTime updatedAt = LocalDateTime.now();
        String updatedBy = "AdminServer";

        Category category = new Category();

        category.setType(type);
        category.setTitle(title);
        category.setCreatedAt(createdAt);
        category.setCreatedBy(createdBy);
        category.setUpdatedAt(updatedAt);
        category.setUpdatedBy(updatedBy);

        Category newCategory = repository.save(category);

        assert newCategory != null;
    }

    @Test
    public void read() {
        Optional<Category> category;

//        category = repository.findById(1L);
//        category.ifPresent(System.out::println);

        category = repository.findByType("CONPUTER");
        category.ifPresent(System.out::println);
    }

}
