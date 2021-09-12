package com.example.mongoext.model;
/*
  @author   george
  @project   mongoext
  @class  Address
  @version  1.0.0 
  @since 12.09.21 - 18.03
*/

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
    private  String country;
    private  String postalCode;
    private  String city;
}
