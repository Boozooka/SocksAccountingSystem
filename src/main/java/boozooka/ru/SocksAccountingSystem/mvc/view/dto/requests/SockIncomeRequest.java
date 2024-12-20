package boozooka.ru.SocksAccountingSystem.mvc.view.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SockIncomeRequest {
    String color;
    Integer cottonPercentage;
    Integer count;
}
