package by.bsuir.timetable.rest.domain.repository;

import by.bsuir.timetable.rest.domain.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {

    Account findByUsername(String username);
}
