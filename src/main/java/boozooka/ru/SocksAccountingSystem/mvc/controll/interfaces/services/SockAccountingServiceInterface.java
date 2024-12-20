package boozooka.ru.SocksAccountingSystem.mvc.controll.interfaces.services;

import boozooka.ru.SocksAccountingSystem.mvc.models.Socks;
import boozooka.ru.SocksAccountingSystem.mvc.view.dto.requests.GetAmountOfFilterSocksRequest;
import boozooka.ru.SocksAccountingSystem.mvc.view.dto.requests.SockIncomeRequest;
import boozooka.ru.SocksAccountingSystem.mvc.view.dto.requests.SockOutcomeRequest;
import boozooka.ru.SocksAccountingSystem.mvc.view.dto.requests.SocksUpdateRequest;
import boozooka.ru.SocksAccountingSystem.mvc.view.dto.responces.FilterSocksResponse;
import boozooka.ru.SocksAccountingSystem.mvc.view.dto.responces.SocksResponse;

public interface SockAccountingServiceInterface {
    Socks socksIncome(SockIncomeRequest request);
    Socks socksOutcome(SockOutcomeRequest request);
    Integer getSocksBy(GetAmountOfFilterSocksRequest request);
    Socks updateSocksBy(SocksUpdateRequest request);
}
