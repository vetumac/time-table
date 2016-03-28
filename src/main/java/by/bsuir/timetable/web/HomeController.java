package by.bsuir.timetable.web;

import by.bsuir.timetable.domain.Route;
import by.bsuir.timetable.domain.Station;
import by.bsuir.timetable.repository.AccountRepository;
import by.bsuir.timetable.repository.CounterService;
import by.bsuir.timetable.repository.RouteRepository;
import by.bsuir.timetable.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.Map;
import java.util.TreeMap;

@RestController
public class HomeController {

    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private CounterService counterService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RouteRepository routeRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String home() {
        return "Hello woffddfrffld!";
    }

    @RequestMapping(value = "/addstation", method = RequestMethod.GET)
    String addStation() {
        stationRepository.save(new Station(counterService.getNextSequence("station"), "NewVasyuki", "Europe/Minsk"));
        //     accountRepository.save(new Account("admin", "admin"));
        Map<Long, Long> route = new TreeMap<>();
        route.put(0L, 11L);
        route.put(10L, 12L);
        routeRepository.save(new Route(counterService.getNextSequence("route"),
                LocalTime.now(),
                1L,
                route));
        return "Added";
    }

    @RequestMapping(value = "/route", method = RequestMethod.GET)
    Route getRoute(@RequestParam(value = "code") Long code) {
        /*Map<Long, Station> route = new TreeMap<>();
        route.put(0L, stationRepository.findByCode(5L));
        route.put(10L, stationRepository.findByCode(6L));
*/
        return /*new Route(counterService.getNextSequence("route"),
                LocalTime.now(),
                LocalTime.now().plusHours(1),
                Period.ofDays(1),
                route)*/
                routeRepository.findByCode(code);
    }

    @RequestMapping(value = "/route", method = RequestMethod.POST)
    void addRoute(@RequestBody Route route) {
        routeRepository.save(route);
    }

    @RequestMapping(value = "/getone", method = RequestMethod.GET)
    String getOne() {
        return String.valueOf(stationRepository.findByCode(1L));
    }


    /*@RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> add(@PathVariable String userId, @RequestBody Bookmark input) {
        this.validateUser(userId);
        return this.accountRepository
                .findByUsername(userId)
                .map(account -> {
                    Bookmark result = bookmarkRepository.save(new Bookmark(account,
                            input.uri, input.description));

                    HttpHeaders httpHeaders = new HttpHeaders();
                    httpHeaders.setLocation(ServletUriComponentsBuilder
                            .fromCurrentRequest().path("/{id}")
                            .buildAndExpand(result.getId()).toUri());
                    return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
                }).get();

    }*/

}
