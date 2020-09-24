package th.go.rd.springbootlayout.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/product/id/{id}")
    public Product findProductById(@PathVariable("id") Integer id) {
        return productRepository.getOne(id);
    }

    @PostMapping("/products")
    public Product create(@RequestBody final Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/products/id/{id}")
    public Product update(@PathVariable("id") Integer id, @RequestBody Product productObject){
        
        Product product = productRepository.getOne(id);
        product.setProduct_name(productObject.getProduct_name());
        product.setProduct_price(productObject.getProduct_price());
        product.setProduct_qty(productObject.getProduct_qty());

        return productRepository.save(product);
    }

    @DeleteMapping("/product/id/{id}")
    public List<Product> delete(@PathVariable("id") Integer id){
        productRepository.deleteById(id);;
        return productRepository.findAll();
    }

}