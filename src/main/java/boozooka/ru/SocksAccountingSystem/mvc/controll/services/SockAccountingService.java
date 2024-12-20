package boozooka.ru.SocksAccountingSystem.mvc.controll.services;

import boozooka.ru.SocksAccountingSystem.mvc.controll.interfaces.services.SockAccountingServiceInterface;
import boozooka.ru.SocksAccountingSystem.mvc.models.Socks;
import boozooka.ru.SocksAccountingSystem.mvc.view.dto.requests.GetAmountOfFilterSocksRequest;
import boozooka.ru.SocksAccountingSystem.mvc.view.dto.requests.SockIncomeRequest;
import boozooka.ru.SocksAccountingSystem.mvc.view.dto.requests.SockOutcomeRequest;
import boozooka.ru.SocksAccountingSystem.mvc.view.dto.requests.SocksUpdateRequest;
import org.springframework.stereotype.Service;

@Service
public class SockAccountingService implements SockAccountingServiceInterface {

    @Override
    public Socks socksIncome(SockIncomeRequest request) {
        return null;
    }

    @Override
    public Socks socksOutcome(SockOutcomeRequest request) {
        return null;
    }

    @Override
    public Integer getSocksBy(GetAmountOfFilterSocksRequest request) {
        return 0;
    }

    @Override
    public Socks updateSocksBy(SocksUpdateRequest request) {
        return null;
    }
}
