package by.bsuir.timetable.rest.converters;

import by.bsuir.timetable.api.dto.RouteDto;
import by.bsuir.timetable.rest.domain.Point;
import by.bsuir.timetable.rest.domain.Route;
import org.springframework.core.convert.converter.Converter;

import java.util.stream.Collectors;

public class RouteConverter implements Converter<RouteDto, Route> {
    @Override
    public Route convert(RouteDto source) {
        return new Route(
                source.getCode(),
                source.getDeparture(),
                source.getStart(),
                source.getEnd(),
                source.getPeriod(),
                source.getPoints().stream().map(pointDto -> new Point(
                        pointDto.getOffset(),
                        pointDto.getStation(),
                        pointDto.getStay()
                )).collect(Collectors.toList()));
    }
}
