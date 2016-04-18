package by.bsuir.timetable.rest.service;

import by.bsuir.timetable.rest.dao.StationRepository;
import by.bsuir.timetable.rest.domain.Station;
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

    public Long saveStation(Station station) {
        if (station.getCode() == null) station.setCode(counterService.getNextSequence("station"));
        return stationRepository.saveStation(station).getCode();
    }

    public List<Station> findByCodeIn(List<Long> codes) {
        return stationRepository.findByCodeIn(codes);
    }

    public Station getStationTimeTable(Long code, String fromDateTime, String toDateTime, String zone) {
        return null;
    }
}
