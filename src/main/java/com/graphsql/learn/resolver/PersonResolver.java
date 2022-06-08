package com.graphsql.learn.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphsql.learn.input.PersonInput;
import com.graphsql.learn.model.Person;
import com.graphsql.learn.repository.PersonRepository;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private PersonRepository repository;

    public Collection<Person> findAllPeople() {
        return repository.findAll();
    }

    public Person findPersonById(Long id) {
        return repository.findById(id).get();
    }

    public Person savePerson(PersonInput input) {
        return repository.save(new Person(input.getName(), input.getAge(), input.getGender()));
    }

    public Person updateAge(Long id, Integer age) {
        Person person = repository.findById(id).get();
        person.setAge(age);
        return repository.save(person);
    }

}
