package by.bsuir.timetable.rest.converters;

import by.bsuir.timetable.api.dto.UserDto;
import by.bsuir.timetable.rest.domain.User;
import org.springframework.core.convert.converter.Converter;

public class UserConverter implements Converter<UserDto, User> {
    @Override
    public User convert(UserDto source) {
        return new User(source.getUsername(), source.getPassword());
    }
}
