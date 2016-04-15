package by.bsuir.timetable.rest.dao;

import by.bsuir.timetable.rest.domain.Route;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RouteRepository extends MongoRepository<Route, String> {
    Route findByCode(Long code);
}