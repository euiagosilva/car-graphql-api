package com.iagosilva.api.service.mapper;

import com.iagosilva.api.domain.Car;
import com.iagosilva.api.service.dto.CarDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-09-03T23:49:59-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_65 (Oracle Corporation)"
)
@Component
public class CarMapperImpl implements CarMapper {

    @Override
    public Car toEntity(CarDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Car car = new Car();

        car.setId( dto.getId() );
        car.setName( dto.getName() );

        return car;
    }

    @Override
    public CarDTO toDto(Car entity) {
        if ( entity == null ) {
            return null;
        }

        CarDTO carDTO = new CarDTO();

        carDTO.setId( entity.getId() );
        carDTO.setName( entity.getName() );

        return carDTO;
    }

    @Override
    public List<Car> toEntity(List<CarDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Car> list = new ArrayList<Car>( dtoList.size() );
        for ( CarDTO carDTO : dtoList ) {
            list.add( toEntity( carDTO ) );
        }

        return list;
    }

    @Override
    public List<CarDTO> toDto(List<Car> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<CarDTO> list = new ArrayList<CarDTO>( entityList.size() );
        for ( Car car : entityList ) {
            list.add( toDto( car ) );
        }

        return list;
    }
}
