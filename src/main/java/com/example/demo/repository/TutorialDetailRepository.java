package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.*;

@Repository
public interface TutorialDetailRepository   extends JpaRepository<TutorialDetail, Long> {

	
	 List<TutorialDetail> findByTutorialsId(Long tutorials_id);
	

}
