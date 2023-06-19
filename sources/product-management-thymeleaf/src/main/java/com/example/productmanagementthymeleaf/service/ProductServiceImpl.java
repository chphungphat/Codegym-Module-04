package com.example.productmanagementthymeleaf.service;

import com.example.productmanagementthymeleaf.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static final Map<Integer, Product> products;

    static {
        products =new HashMap<>();
        products.put(1, new Product(1, "AK47", "Assault rifle", 3000));
        products.put(2, new Product(2, "M79", "Grenade launcher", 4000));
        products.put(3, new Product(3, "B41", "Rocket launcher", 10000));
        products.put(4, new Product(4, "RPD", "Machine gun", 6000));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> search(String searchString) {
        List<Product> productList = findAll();
        List<Product> resultList = new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().toLowerCase().contains(searchString.toLowerCase()) ||
                product.getDescription().toLowerCase().contains(searchString.toLowerCase())) {

                resultList.add(product);
            }
        }
        return resultList;
    }
}
