package boozooka.ru.SocksAccountingSystem.mvc.controll.interfaces.services;

import boozooka.ru.SocksAccountingSystem.mvc.models.Socks;
import boozooka.ru.SocksAccountingSystem.mvc.view.dto.requests.*;
import boozooka.ru.SocksAccountingSystem.mvc.view.dto.responses.SuccessFileReadingResponse;

public interface SockAccountingServiceInterface {
    Socks socksIncome(SockIncomeRequest request);
    Socks socksOutcome(SockOutcomeRequest request);
    Integer getSocksBy(GetAmountOfFilterSocksRequest request);
    Socks updateSocksBy(Long updatingId, SocksUpdateRequest request);
    boolean csvBatch(CsvBatchRequest request);
}
