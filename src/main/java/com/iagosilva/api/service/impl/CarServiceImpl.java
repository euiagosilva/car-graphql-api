package com.iagosilva.api.service.impl;

import com.iagosilva.api.domain.Car;
import com.iagosilva.api.repository.CarRepository;
import com.iagosilva.api.service.CarService;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository repository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.repository = carRepository;
    }

    @GraphQLQuery(name = "cars")
    public List<Car> getCars() {
        return repository.findAll();
    }

    @GraphQLQuery(name = "car")
    public Optional<Car> getCarById(@GraphQLArgument(name = "id") Long id) {
        return repository.findById(id);
    }

    @GraphQLMutation(name = "saveCar")
    public Car saveCar(@GraphQLArgument(name = "car") Car car) {
        return repository.save(car);
    }

    @GraphQLMutation(name = "deleteCar")
    public void deleteCar(@GraphQLArgument(name = "id") Long id) {
        repository.deleteById(id);
    }

    @GraphQLQuery(name = "isCool")
    public boolean isCool(@GraphQLContext Car car) {
        return !car.getName().equals("AMC Gremlin") &&
                !car.getName().equals("Triumph Stag") &&
                !car.getName().equals("Ford Pinto") &&
                !car.getName().equals("Yugo GV");
    }
}
