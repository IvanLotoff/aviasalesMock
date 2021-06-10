package ivan.projects.aviasales.repository;

import ivan.projects.aviasales.domain.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.Scanner;

@Repository
@Slf4j
public class FlightRepositoryImpl implements FlightsRepository{

    @Override
    public Response findResponseById(int id) {
        try {
            InputStream inputStream = new ClassPathResource(File.separator + "flights.csv").getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String curLine;
            while ((curLine = reader.readLine()) != null){
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
