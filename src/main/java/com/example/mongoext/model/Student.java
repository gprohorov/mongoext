package com.example.mongoext.model;
/*
  @author   george
  @project   mongoext
  @class  Student
  @version  1.0.0 
  @since 12.09.21 - 17.59
*/

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@Document
public class Student {
     @Id
     private String id;
     private String firstName;
     private String lastName;
     @Indexed(unique = true)
     private String email;
     private Gender gender;
     private Address address;
     private List<String> subjects;
     private Integer totalSpentInbooks;
     private LocalDateTime createdAt;

     public Student(String firstName, String lastName, String email, Gender gender, Address address, List<String> subjects, Integer totalSpentInbooks, LocalDateTime createdAt) {
          this.firstName = firstName;
          this.lastName = lastName;
          this.email = email;
          this.gender = gender;
          this.address = address;
          this.subjects = subjects;
          this.totalSpentInbooks = totalSpentInbooks;
          this.createdAt = createdAt;
     }

     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (!(o instanceof Student)) return false;
          Student student = (Student) o;
          return getId().equals(student.getId());
     }

     @Override
     public int hashCode() {
          return Objects.hash(getId());
     }
}
