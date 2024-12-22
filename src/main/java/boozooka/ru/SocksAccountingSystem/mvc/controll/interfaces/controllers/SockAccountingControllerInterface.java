package boozooka.ru.SocksAccountingSystem.mvc.controll.interfaces.controllers;

import boozooka.ru.SocksAccountingSystem.mvc.view.dto.requests.*;
import boozooka.ru.SocksAccountingSystem.mvc.view.dto.responses.FilterSocksResponse;
import boozooka.ru.SocksAccountingSystem.mvc.view.dto.responses.SocksResponse;
import boozooka.ru.SocksAccountingSystem.mvc.view.dto.responses.SuccessFileReadingResponse;

public interface SockAccountingControllerInterface {
    SocksResponse socksIncome(SockIncomeRequest request);
    SocksResponse socksOutcome(SockOutcomeRequest request);
    FilterSocksResponse getSocksBy(GetAmountOfFilterSocksRequest request);
    SocksResponse updateSocksBy(Long updatingId, SocksUpdateRequest request);
    SuccessFileReadingResponse csvBatch(CsvBatchRequest request);

}
