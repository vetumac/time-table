package by.bsuir.timetable.desktop.service;

import by.bsuir.timetable.desktop.dto.StationDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class StationService {

    @Value("${host}")
    private String host;

    public List<StationDto> findStationByNameLike(String name) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<StationDto[]> responseEntity = restTemplate.getForEntity(host + "/station?name=" + name, StationDto[].class);
        StationDto[] stations = responseEntity.getBody();
        return Arrays.asList(stations);
    }

    public StationDto findByCode(Long code) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(host + "/station/" + code.toString(), StationDto.class);
    }
}
