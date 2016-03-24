package by.bsuir.timetable.repository;

import by.bsuir.timetable.domain.Route;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RouteRepository extends MongoRepository<Route, String> {
    Route findByCode(Long code);
}
