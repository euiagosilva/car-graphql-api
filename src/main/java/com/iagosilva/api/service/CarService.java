package com.iagosilva.api.service;

import com.iagosilva.api.domain.Car;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import java.util.List;
import java.util.Optional;

public interface CarService {

    List<Car> getCars();

    Optional<Car> getCarById(@GraphQLArgument(name = "id") Long id);

    Car saveCar(@GraphQLArgument(name = "car") Car car);

    void deleteCar(@GraphQLArgument(name = "id") Long id);

    boolean isCool(@GraphQLContext Car car);

}
