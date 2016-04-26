package by.bsuir.timetable.desktop.service;

import by.bsuir.timetable.api.dto.TimetableDto;
import by.bsuir.timetable.desktop.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TimetableService {

    @Autowired
    private RestClient restClient;

    public TimetableDto getTimetible(Long code, LocalDateTime from, LocalDateTime to) {
        return restClient.template().getForObject(restClient.apiUrl("/timetable/" + code + "?from=" + from.toString() + "&to=" + to.toString()), TimetableDto.class);
    }

}
