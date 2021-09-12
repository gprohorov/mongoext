package com.example.mongoext;

import com.example.mongoext.model.Address;
import com.example.mongoext.model.Gender;
import com.example.mongoext.model.Student;
import com.example.mongoext.repoository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MongoextApplication {

    public static void main(String[] args) {

        SpringApplication.run(MongoextApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(StudentRepository repository,
                             MongoTemplate mongoTemplate){
        return args -> {
            Address address = new Address("Poland", "0009",":Lodz");
            List<String> subjects = new ArrayList<>(Arrays.asList("Computer Science", "Maths", "DB"));
            String email = "jasc@gmail.com";
            Student student = new Student(
                    "Jasc", "Mazovecky", email, Gender.MALE, address,
                    subjects,  10, LocalDateTime.now()

            );

            Query query = new Query();
            query.addCriteria(Criteria.where("email").is(email));
            List<Student> students = mongoTemplate.find(query, Student.class);

            if(students.isEmpty()){
                 repository.insert(student);
            }else {
                throw new IllegalStateException(" Email " + email + " is already exists");
            }


        };

    }

}
