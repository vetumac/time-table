package by.bsuir.timetable.rest.domain.repository;

import by.bsuir.timetable.rest.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(String username);
}
