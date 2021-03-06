package lordsoftheplanets.ktochto.Repository;

import lordsoftheplanets.ktochto.Model.Planet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends CrudRepository<Planet, Long> {

    Planet findByName(String name);

}
