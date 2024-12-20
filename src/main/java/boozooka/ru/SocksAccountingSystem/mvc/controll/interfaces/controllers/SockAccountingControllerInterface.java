package boozooka.ru.SocksAccountingSystem.mvc.controll.interfaces.controllers;

import boozooka.ru.SocksAccountingSystem.mvc.models.Socks;
import boozooka.ru.SocksAccountingSystem.mvc.view.dto.requests.GetAmountOfFilterSocksRequest;
import boozooka.ru.SocksAccountingSystem.mvc.view.dto.requests.SockIncomeRequest;
import boozooka.ru.SocksAccountingSystem.mvc.view.dto.requests.SockOutcomeRequest;
import boozooka.ru.SocksAccountingSystem.mvc.view.dto.requests.SocksUpdateRequest;
import boozooka.ru.SocksAccountingSystem.mvc.view.dto.responces.FilterSocksResponse;
import boozooka.ru.SocksAccountingSystem.mvc.view.dto.responces.SocksResponse;

public interface SockAccountingControllerInterface {
    SocksResponse socksIncome(SockIncomeRequest request);
    SocksResponse socksOutcome(SockOutcomeRequest request);
    FilterSocksResponse getSocksBy(GetAmountOfFilterSocksRequest request);
    SocksResponse updateSocksBy(SocksUpdateRequest request);

}
