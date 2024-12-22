package boozooka.ru.SocksAccountingSystem.mvc.view.dto.responses;

import boozooka.ru.SocksAccountingSystem.mvc.models.Socks;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocksResponse {
    private Socks socks;
}
