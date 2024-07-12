package com.example.demo.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Tutorial;
import com.example.demo.entity.TutorialDetail;
import com.example.demo.repository.TutorialDetailRepository;
import com.example.demo.repository.TutorialRepository;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/tutorials")
public class CourseController {
	
	  @Autowired
	    private TutorialDetailRepository tutorialDetailRepository;

		@RequestMapping(value = "/helloWorld", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public String create() throws URISyntaxException {

			return "Hello World";
		}
	
	 @Autowired
	    private TutorialRepository tutorialRepository;
	    
	    @GetMapping
	    public List<Tutorial> getAllTutorials() {
	        return tutorialRepository.findAll();
	    }
	    
	    @PostMapping
	    public Tutorial createTutorial(@RequestBody Tutorial tutorial) {
	        return tutorialRepository.save(tutorial);
	    }
	    
	    @GetMapping("/{tutorials_id}")
	    public ResponseEntity<List<TutorialDetail>> getTutorialDetails(@PathVariable Long tutorials_id) {
	        List<TutorialDetail> tutorialDetails = tutorialDetailRepository.findByTutorialsId(tutorials_id);
	        return ResponseEntity.ok(tutorialDetails);

}
}