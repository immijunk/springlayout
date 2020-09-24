package th.go.rd.springbootlayout.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import th.go.rd.springbootlayout.repository.ProductRepository;

@RestController
public class ProductAPIController {
    
    @Autowired
    private ProductRepository productRepository;
    
}