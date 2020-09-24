package th.go.rd.springbootlayout.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import th.go.rd.springbootlayout.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
    
}