package by.bsuir.timetable.domain.repository;

import by.bsuir.timetable.domain.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {

    Account findByUsername(String username);
}
