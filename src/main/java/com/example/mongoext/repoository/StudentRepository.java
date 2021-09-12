package com.example.mongoext.repoository;
/*
  @author   george
  @project   mongoext
  @class  StudentRepository
  @version  1.0.0 
  @since 12.09.21 - 18.22
*/

import com.example.mongoext.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
}
