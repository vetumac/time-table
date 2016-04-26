package by.bsuir.timetable.rest.dao;

import by.bsuir.timetable.rest.domain.Route;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface RouteRepository extends MongoRepository<Route, String> {
    Route findByCode(Long code);

    default Route saveRoute(Route route) {
        Route currentRoute = findByCode(route.getCode());
        if (currentRoute != null) route.setId(currentRoute.getId());
        return save(route);
    }

    @Query("{ 'points.station': ?0, 'firstDeparture': { $lt: ?2 }, 'end': { $gt: ?1 }}")
    List<Route> findByStationAndFromAndTo(Long code, LocalDateTime from, LocalDateTime to);
}
