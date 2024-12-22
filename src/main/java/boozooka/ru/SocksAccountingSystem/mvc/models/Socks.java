package boozooka.ru.SocksAccountingSystem.mvc.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "socks")
public class Socks {

    @Column(name = "id", nullable = false)
    @Id
    private Long id;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "cotton_percentage", nullable = false)
    private Integer cottonPercentage;

    @Column(name = "count", nullable = false)
    private Integer count;

    public void addCount(Integer countAdd){
        count += countAdd;
    }

    public boolean reduceCount(Integer countReduce){
        if (count < countReduce){
            return false;
        } else {
            count -= countReduce;
            return true;
        }
    }
}
