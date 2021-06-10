package ivan.projects.aviasales.repository;

import ivan.projects.aviasales.domain.Response;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.Scanner;

@Repository
public class FlightRepositoryImpl implements FlightsRepository{

    @Override
    public Response findResponseById(int id) {
        try {
            File file = new ClassPathResource("flights.csv").getFile();
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
        catch (Exception ignored){

        }
        return null;
    }
}
