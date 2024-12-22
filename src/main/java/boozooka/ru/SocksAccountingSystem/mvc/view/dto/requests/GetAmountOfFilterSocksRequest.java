package boozooka.ru.SocksAccountingSystem.mvc.view.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAmountOfFilterSocksRequest {
    private String color;
    private Integer cottonPercentage;
    private Integer countMoreThan;
    private Integer countLessThan;
    private Integer countEquals;
}
