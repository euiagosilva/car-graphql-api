package com.iagosilva.api.domain;

import io.leangen.graphql.annotations.GraphQLQuery;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Car {

    @Id
    @GeneratedValue
    @GraphQLQuery(name = "id", description = "A car's id")
    private Long id;

    @NonNull
    @GraphQLQuery(name = "name", description = "A car's name")
    private String name;
}