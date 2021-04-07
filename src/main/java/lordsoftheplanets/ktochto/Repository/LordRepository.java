package lordsoftheplanets.ktochto.Repository;

import lordsoftheplanets.ktochto.Model.Lord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LordRepository extends JpaRepository<Lord, Long> {

    @Query(value = "SELECT id, name, age FROM lord order by age limit 10", nativeQuery = true)
    List<Lord> findTopYoungest();

    @Query(value = "SELECT id, name, age\n" +
            "FROM lord LEFT OUTER JOIN lord_planets ON\n" +
            "lord.id = lord_planets.lord_id\n" +
            "WHERE lord_planets.lord_id IS NULL", nativeQuery = true)
    List<Lord> findAllNotOwners();

}
