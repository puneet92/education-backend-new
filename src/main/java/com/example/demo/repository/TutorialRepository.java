package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Tutorial;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

	
	
	    
	    // You can add custom repository methods here, for example:
	    List<Tutorial> findByTitleContaining(String title);
	}
	

