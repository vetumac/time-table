package by.bsuir.timetable.rest.converters;

import by.bsuir.timetable.api.dto.RouteDto;
import by.bsuir.timetable.rest.domain.Route;
import org.springframework.core.convert.converter.Converter;

public class RouteConverter implements Converter<RouteDto, Route> {
    @Override
    public Route convert(RouteDto source) {
        return new Route(
                source.getCode(),
                source.getDeparture(),
                source.getStart(),
                source.getEnd(),
                source.getPeriod(),
                source.getPoints());
    }
}
