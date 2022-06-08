package com.graphsql.learn.input;


import com.graphsql.learn.model.Gender;
import graphql.schema.GraphQLInputType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonInput implements GraphQLInputType {

    private String name;
    private Integer age;
    private Gender gender;
}
