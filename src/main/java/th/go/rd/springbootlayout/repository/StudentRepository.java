package th.go.rd.springbootlayout.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import th.go.rd.springbootlayout.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
    
}