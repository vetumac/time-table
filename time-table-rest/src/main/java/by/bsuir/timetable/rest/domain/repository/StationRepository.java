package by.bsuir.timetable.rest.domain.repository;

import by.bsuir.timetable.rest.domain.Station;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StationRepository extends MongoRepository<Station, String> {
    List<Station> findByNameLike(String name);
    Station findByCode(Long code);
    List<Station> findByCodeIn(List<Long> codes);
}
