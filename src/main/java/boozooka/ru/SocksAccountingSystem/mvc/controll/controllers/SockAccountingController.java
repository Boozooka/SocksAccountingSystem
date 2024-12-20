package boozooka.ru.SocksAccountingSystem.mvc.controll.controllers;

import boozooka.ru.SocksAccountingSystem.mvc.controll.interfaces.controllers.SockAccountingControllerInterface;
import boozooka.ru.SocksAccountingSystem.mvc.controll.interfaces.services.SockAccountingServiceInterface;
import boozooka.ru.SocksAccountingSystem.mvc.view.dto.requests.GetAmountOfFilterSocksRequest;
import boozooka.ru.SocksAccountingSystem.mvc.view.dto.requests.SockIncomeRequest;
import boozooka.ru.SocksAccountingSystem.mvc.view.dto.requests.SockOutcomeRequest;
import boozooka.ru.SocksAccountingSystem.mvc.view.dto.requests.SocksUpdateRequest;
import boozooka.ru.SocksAccountingSystem.mvc.view.dto.responces.FilterSocksResponse;
import boozooka.ru.SocksAccountingSystem.mvc.view.dto.responces.SocksResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/api/socks")
public class SockAccountingController implements SockAccountingControllerInterface {

    @Autowired
    SockAccountingServiceInterface service;

    @Override
    @PostMapping(value = "/income")
    public SocksResponse socksIncome(SockIncomeRequest request) {

        return null;
    }

    @Override
    @PostMapping(value = "/outcome")
    public SocksResponse socksOutcome(SockOutcomeRequest request) {
        return null;
    }

    @Override
    public FilterSocksResponse getSocksBy(GetAmountOfFilterSocksRequest request) {
        return null;
    }

    @Override
    public SocksResponse updateSocksBy(SocksUpdateRequest request) {
        return null;
    }
}
