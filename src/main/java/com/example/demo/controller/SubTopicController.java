package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.SubTopic;
import com.example.demo.repository.SubTopicRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/subtopics")
public class SubTopicController {

    @Autowired
    private SubTopicRepository subTopicRepository;

    @GetMapping("/{topicId}")
    public ResponseEntity<List<SubTopic>> getSubTopicsByTopicId(@PathVariable Long topicId) {
        List<SubTopic> subTopics = subTopicRepository.findByTopicId(topicId);
        return ResponseEntity.ok(subTopics);
    }
}
