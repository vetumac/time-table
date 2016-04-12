package by.bsuir.timetable.desktop.service;

import by.bsuir.timetable.desktop.RestClient;
import by.bsuir.timetable.desktop.dto.StationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class StationService {

    @Autowired
    private RestClient restClient;

    public List<StationDto> findStationByNameLike(String name) {
        ResponseEntity<StationDto[]> responseEntity = restClient.template().getForEntity(restClient.apiUrl("/station?name=" + name), StationDto[].class);
        StationDto[] stations = responseEntity.getBody();

        return Arrays.asList(stations);
    }

    public StationDto findByCode(Long code) {
        RestTemplate restTemplate = new RestTemplate();
        return restClient.template().getForObject(restClient.apiUrl("/station/" + code.toString()), StationDto.class);
    }
}
