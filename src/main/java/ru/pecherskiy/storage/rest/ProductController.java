package ru.pecherskiy.storage.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pecherskiy.storage.model.Product;
import ru.pecherskiy.storage.servicve.ProductService;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Slf4j
@RequestMapping(path = "/api/products/")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(path = "")
    public @ResponseBody
    Product addNewProduct(@RequestBody Product product) {
        return productService.add(product);
    }

    @PutMapping(path = "")
    public @ResponseBody
    Product editProduct(@RequestBody Product product) {
        return productService.edit(product);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Long> deleteProduct(@PathVariable Long id) {

        boolean isRemoved = productService.delete(id);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);
    }


    @GetMapping(path = "")
    public @ResponseBody
    List<Product> getAllProducts() {
        return productService.getAll();
    }

}