package by.bsuir.timetable.domain.repository;

import by.bsuir.timetable.domain.Station;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StationRepository extends MongoRepository<Station, String> {
    List<Station> findByNameLike(String name);
    Station findByCode(Long code);

    List<Station> findByCodeIn(List<Long> codes);
}
