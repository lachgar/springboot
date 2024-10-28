package com.example.demo.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	// Recherche d'un étudiant par son identifiant (méthode héritée de JpaRepository mais réécrite ici)
	Student findById(int id);

	// Requête personnalisée pour obtenir le nombre d'étudiants par année de naissance
	// Utilisation de la fonction year() sur la date de naissance pour regrouper les étudiants par année
	@Query("SELECT YEAR(s.dateNaissance), COUNT(s) FROM Student s GROUP BY YEAR(s.dateNaissance) ORDER BY YEAR(s.dateNaissance)")
	Collection<Object[]> findNbrStudentByYear();


}
