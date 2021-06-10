package ivan.projects.aviasales.repository;

import ivan.projects.aviasales.domain.Response;

/**
 * Здесь мы выделяем интерфейс слоя базы данных
 * и следуем принципу SOLID о том, что реализацию
 * нужно заменить абстракцией. Так, если мы решим в будущем
 * брать данные не из csv файла, а из базы данных, нам придется
 * всего лишь добавить другой bean в спринг конейтер, который реализует FlightsRepository,
 * однако остальные куски кода, где FlightsRepository инджектится
 * останутся без изменений
 */
public interface FlightsRepository {
    Response findResponseById(int id);
}
