package th.go.rd.springbootlayout.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import th.go.rd.springbootlayout.model.Product;
import th.go.rd.springbootlayout.repository.ProductRepository;

@RestController
@RequestMapping("api")
public class ProductAPIController {
    
    @Autowired
    private ProductRepository productRepository;


    //Read all product 
    @GetMapping("/product")
    public List<Product> findall(){
        return productRepository.findAll();
    }

}