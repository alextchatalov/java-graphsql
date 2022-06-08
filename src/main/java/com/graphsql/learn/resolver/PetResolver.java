package com.graphsql.learn.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphsql.learn.input.PetInput;
import com.graphsql.learn.model.Person;
import com.graphsql.learn.model.Pet;
import com.graphsql.learn.repository.PersonRepository;
import com.graphsql.learn.repository.PetRepository;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PetResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PersonRepository personRepository;

    public Collection<Pet> findAllPets() {
        return petRepository.findAll();
    }

    public Pet savePet(PetInput input) {
        Person owner = personRepository.findById(input.getOwnerId()).get();
        return petRepository.save(new Pet(input.getName(), owner));
    }
}
