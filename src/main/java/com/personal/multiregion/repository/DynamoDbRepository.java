package com.personal.multiregion.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.personal.multiregion.model.Assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DynamoDbRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Assignment insert(Assignment assignment){
        dynamoDBMapper.save(assignment);
        return assignment;
    }

    public Assignment getAssignmentDetails(String assignmentId, String studentId){
        return dynamoDBMapper.load(Assignment.class,assignmentId,studentId);
    }
}
