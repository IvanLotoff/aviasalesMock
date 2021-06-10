package ivan.projects.aviasales.controller;

import ivan.projects.aviasales.domain.Response;
import ivan.projects.aviasales.repository.FlightsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final FlightsRepository repository;

    @GetMapping("/flights/{id}")
    public Response getFlightById(@PathVariable int id){
        return repository.findResponseById(id);
    }
}
