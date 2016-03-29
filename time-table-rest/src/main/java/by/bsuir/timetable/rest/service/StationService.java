package by.bsuir.timetable.rest.service;

import by.bsuir.timetable.rest.domain.Station;
import by.bsuir.timetable.rest.domain.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService {

    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private CounterService counterService;

    public Station findByCode(Long code) {
        return stationRepository.findByCode(code);
    }

    public List<Station> findByNameLike(String name) {
        return stationRepository.findByNameLike(name);
    }

    public Long addStation(Station station) {
        station.setCode(counterService.getNextSequence("station"));
        return stationRepository.save(station).getCode();
    }

    public List<Station> findByCodeIn(List<Long> codes) {
        return stationRepository.findByCodeIn(codes);
    }
}
