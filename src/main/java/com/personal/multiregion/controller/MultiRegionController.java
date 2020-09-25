package com.personal.multiregion.controller;

import com.personal.multiregion.model.Assignment;
import com.personal.multiregion.repository.DynamoDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MultiRegionController {

    @Autowired
    private DynamoDbRepository dynamoDbRepository;

    @PostMapping("/assignment")
    public ResponseEntity<Assignment> createAssignment(@RequestBody Assignment assignment){
        assignment = dynamoDbRepository.insert(assignment);
        return new ResponseEntity<>(assignment,HttpStatus.CREATED);
    }

    @GetMapping("/assignment")
    public ResponseEntity<Assignment> getAssignmentDetails(@RequestParam String assignmentId, @RequestParam String userId){
        Assignment assignment = dynamoDbRepository.getAssignmentDetails(assignmentId,userId);
        return new ResponseEntity<>(assignment, HttpStatus.OK);
    }

    @GetMapping("/health")
    public boolean getHealthCheck(){
        return true;
    }
}
