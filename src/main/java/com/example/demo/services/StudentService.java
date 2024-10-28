package com.example.demo.services;

import com.example.demo.entities.Student;
import com.example.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Sauvegarder un étudiant
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    // Supprimer un étudiant par ID
    public boolean delete(int id) {
        Optional<Student> studentOptional = Optional.ofNullable(studentRepository.findById(id));
        if (studentOptional.isPresent()) {
            studentRepository.delete(studentOptional.get());
            return true;
        } else {
            return false;
        }
    }

    // Récupérer tous les étudiants
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    // Compter le nombre total d'étudiants
    public long countStudents() {
        return studentRepository.count();
    }

    // Récupérer le nombre d'étudiants par année
    public Collection<?> findNbrStudentByYear() {
        return studentRepository.findNbrStudentByYear();
    }
}
