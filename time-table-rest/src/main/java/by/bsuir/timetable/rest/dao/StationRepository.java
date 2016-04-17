package by.bsuir.timetable.rest.dao;

import by.bsuir.timetable.rest.domain.Station;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StationRepository extends MongoRepository<Station, String> {

    List<Station> findByNameLike(String name);

    Station findByCode(Long code);

    List<Station> findByCodeIn(List<Long> codes);

    default Station saveStation(Station station) {
        Station currentStation = findByCode(station.getCode());
        if (currentStation != null) station.setId(currentStation.getId());
        return save(station);
    }
}
