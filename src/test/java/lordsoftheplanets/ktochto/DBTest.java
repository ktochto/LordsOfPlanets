package lordsoftheplanets.ktochto;

import lordsoftheplanets.ktochto.Model.Lord;
import lordsoftheplanets.ktochto.Model.Planet;
import lordsoftheplanets.ktochto.Repository.LordRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DBTest {

    @Autowired
    private LordRepository lordRepository;

    @Test
    public void testSaveToDB() {
        Lord lord = new Lord();
        lord.setAge(10);
        lord.setName("jshhs");
        List<Lord> lords = lordRepository.findAll();
        assertThat(lords.isEmpty());
        lordRepository.save(lord);
        assertEquals(lordRepository.findAll().get(0), lord);
    }

    @Test
    public void testTop() {
        List<Lord> lords = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Lord lord = new Lord();
            lord.setAge(i);
            if (i < 10) {
                lords.add(lord);
            }
            lordRepository.save(lord);
        }

        assertEquals(lords, lordRepository.findTopYoungest());
    }

    @Test
    public void testNotOwners() {
        List<Lord> notOwners = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Lord lord = new Lord();
            lord.setAge(i);
            lord.setName(String.valueOf(i));
            if (i % 3 == 0) {
                HashSet<Planet> planets = new HashSet<>();
                planets.add(new Planet());
                lord.setPlanets(planets);
            } else {
                notOwners.add(lord);
            }
            lordRepository.save(lord);
        }

        assertEquals(notOwners, lordRepository.findAllNotOwners());
    }

}
