package com.pad.mysql.demo.controller;

import com.pad.mysql.demo.data.Product;
import com.pad.mysql.demo.repo.ProductRepository;
import com.pad.mysql.demo.util.ProductNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepo;
    

    @RequestMapping (value="/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") int id, @RequestBody Product prod){

       
        if(!productRepo.findById(id).isPresent()) throw new ProductNotFoundException();
        
        productRepo.save(prod);

        return new ResponseEntity<>("Product Successfully updated",HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Object> getProduct(){
        
        return new ResponseEntity<>(productRepo.findAll(),HttpStatus.OK);
    }

    @GetMapping(value="/init")
    public ResponseEntity<Object> initProducts(){
        Product A = new Product();
        A.setId(1);
        A.setName("AProduct");
        A.setDesc("ADesc");
        Product B = new Product();
        B.setId(2);
        B.setName("BProduct");
        B.setDesc("BDesc");
        productRepo.save(A);
        productRepo.save(B);

        return new ResponseEntity<>("Succesfully added",HttpStatus.OK);
    }

}