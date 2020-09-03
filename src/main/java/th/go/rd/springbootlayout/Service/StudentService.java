package th.go.rd.springbootlayout.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.go.rd.springbootlayout.model.Student;
import th.go.rd.springbootlayout.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student getOne(int Id){
        return studentRepository.getOne(Id);
    }

    public Student save(Student std){
        return studentRepository.save(std);
    }

    public void delete(Student std){
        studentRepository.delete(std);
    }

 }