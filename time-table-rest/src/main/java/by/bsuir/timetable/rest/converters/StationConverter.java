package by.bsuir.timetable.rest.converters;

import by.bsuir.timetable.api.dto.StationDto;
import by.bsuir.timetable.rest.domain.Station;
import org.springframework.core.convert.converter.Converter;

public class StationConverter implements Converter<StationDto, Station> {
    @Override
    public Station convert(StationDto source) {
        return new Station(
                source.getCode(),
                source.getName(),
                source.getZone()
        );
    }
}
