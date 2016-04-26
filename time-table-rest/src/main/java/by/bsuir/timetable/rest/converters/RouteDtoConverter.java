package by.bsuir.timetable.rest.converters;

import by.bsuir.timetable.api.dto.PointDto;
import by.bsuir.timetable.api.dto.RouteDto;
import by.bsuir.timetable.rest.domain.Route;
import org.springframework.core.convert.converter.Converter;

import java.util.stream.Collectors;

public class RouteDtoConverter implements Converter<Route, RouteDto> {
    @Override
    public RouteDto convert(Route source) {
        return new RouteDto(
                source.getCode(),
                source.getFirstDeparture(),
                source.getEnd(),
                source.getPeriod(),
                source.getPoints().stream().map(pointDto -> new PointDto(
                        pointDto.getOffset(),
                        pointDto.getStation(),
                        pointDto.getStay()
                )).collect(Collectors.toList()));
    }
}
