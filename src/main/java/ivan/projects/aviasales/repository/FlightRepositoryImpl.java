package ivan.projects.aviasales.repository;

import ivan.projects.aviasales.domain.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.Scanner;

@Repository
@Slf4j
public class FlightRepositoryImpl implements FlightsRepository{

    @Value("flight.csv")
    public Resource flights;

    @Override
    public Response findResponseById(int id) {
        try {
            File file = flights.getFile();
            Scanner scanner = new Scanner(file);
            String curLine;
            while ((curLine = scanner.nextLine()) != null){
                String[] strings = curLine.split(";");
                if(strings[0].equals(String.valueOf(id))){
                    return Response.builder()
                            .arrivalTime(strings[6])
                            .departureTime(strings[4])
                            .number(strings[7])
                            .build();
                }
            }
        }
        catch (Exception exception){
            log.error(exception.getMessage());
        }
        return null;
    }
}
