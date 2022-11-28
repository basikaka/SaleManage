package com.hogrider.service;

import com.hogrider.dao.CategoryDAO;
import com.hogrider.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryDAO categoryDAO;

    public List<Category> list(){
        Sort sort;
        sort = Sort.by( Sort.Direction.DESC, "id");
        return categoryDAO.findAll(sort);
    }

    public Category get(Integer id){
        Category category = categoryDAO.findById( id).orElse(null);
        return category;
    }
}
