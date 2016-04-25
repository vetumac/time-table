package by.bsuir.timetable.rest.converters;

import by.bsuir.timetable.api.dto.StationDto;
import by.bsuir.timetable.rest.domain.Station;
import org.springframework.core.convert.converter.Converter;

public class StationDtoConverter implements Converter<Station, StationDto> {
    @Override
    public StationDto convert(Station source) {
        return new StationDto(
                source.getCode(),
                source.getName(),
                source.getZone());
    }
}
