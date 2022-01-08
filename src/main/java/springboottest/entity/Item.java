package springboottest.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "items")
@NoArgsConstructor
public class Item
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @Getter
    @Setter
    private int id;
    
    @Getter
    @Setter
    @Column(nullable = false)
    private String name;
    
    public Item(String name)
    {
        this.name = name;
    }
}
