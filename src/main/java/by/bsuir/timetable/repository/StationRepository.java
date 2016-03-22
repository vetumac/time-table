package by.bsuir.timetable.repository;

import by.bsuir.timetable.domain.Station;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StationRepository extends MongoRepository<Station, String> {
    Station findByName(String name);
}
