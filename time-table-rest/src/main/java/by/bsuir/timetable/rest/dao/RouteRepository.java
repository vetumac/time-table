package by.bsuir.timetable.rest.dao;

import by.bsuir.timetable.rest.domain.Route;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface RouteRepository extends MongoRepository<Route, String> {

    Route findByCode(Long code);

    @Query(value = "{'route' : {$all : [?0] }}")
    List<Route> findAnyOfTheseValues(String[] values);
}
