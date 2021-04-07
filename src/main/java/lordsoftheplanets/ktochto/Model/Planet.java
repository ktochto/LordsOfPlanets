package lordsoftheplanets.ktochto.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "lord_id", referencedColumnName = "id")
    private Lord lord;

}
