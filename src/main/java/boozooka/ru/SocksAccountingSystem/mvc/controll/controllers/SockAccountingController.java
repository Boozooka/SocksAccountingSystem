package boozooka.ru.SocksAccountingSystem.mvc.controll.controllers;

import boozooka.ru.SocksAccountingSystem.exceptions.FileProcessingException;
import boozooka.ru.SocksAccountingSystem.exceptions.InvalidRequestException;
import boozooka.ru.SocksAccountingSystem.mvc.controll.interfaces.controllers.SockAccountingControllerInterface;
import boozooka.ru.SocksAccountingSystem.mvc.controll.interfaces.services.SockAccountingServiceInterface;
import boozooka.ru.SocksAccountingSystem.mvc.models.Socks;
import boozooka.ru.SocksAccountingSystem.mvc.view.dto.requests.*;
import boozooka.ru.SocksAccountingSystem.mvc.view.dto.responses.FilterSocksResponse;
import boozooka.ru.SocksAccountingSystem.mvc.view.dto.responses.SocksResponse;
import boozooka.ru.SocksAccountingSystem.mvc.view.dto.responses.SuccessFileReadingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/socks")
public class SockAccountingController implements SockAccountingControllerInterface {

    @Autowired
    SockAccountingServiceInterface service;

    @Override
    @PostMapping("/income")
    public SocksResponse socksIncome(@RequestBody SockIncomeRequest request) {
        if (request.getCottonPercentage() < 0 || request.getCottonPercentage() > 100){
            throw new InvalidRequestException("Cotton percentage must be between 0 and 100");
        }
        if (request.getCount() <= 0){
            throw new InvalidRequestException("Count of socks must be more than 0");
        }
        if (request.getColor() == null || request.getColor().isEmpty()){
            throw new InvalidRequestException("Color mustn't be null");
        }

        Socks incomeSocks = service.socksIncome(request);
        return new SocksResponse(incomeSocks);
    }

    @Override
    @PostMapping(value = "/outcome")
    public SocksResponse socksOutcome(@RequestBody SockOutcomeRequest request) {
        if (request.getCottonPercentage() < 0 || request.getCottonPercentage() > 100){
            throw new InvalidRequestException("Cotton percentage must be between 0 and 100");
        }
        if (request.getCount() <= 0){
            throw new InvalidRequestException("Count of socks must be more than 0");
        }
        if (request.getColor() == null || request.getColor().isEmpty()){
            throw new InvalidRequestException("Color mustn't be null");
        }

        Socks remainingSocks = service.socksOutcome(request);
        return new SocksResponse(remainingSocks);
    }

    @Override
    @GetMapping("")
    public FilterSocksResponse getSocksBy(@RequestBody GetAmountOfFilterSocksRequest request) {
        Integer result = service.getSocksBy(request);
        return new FilterSocksResponse(result);
    }

    @Override
    @PutMapping("/")
    public SocksResponse updateSocksBy(@RequestParam(value = "id") Long updatingId, @RequestBody SocksUpdateRequest request) {
        if (updatingId == null || updatingId <= 0){
            throw new InvalidRequestException("Updating id must be more than 0 and not be null");
        }
        if (request.getUpdatingColumn() == null || request.getUpdatingColumn().isEmpty()){
            throw new InvalidRequestException("'Updating column' must not be null");
        }
        if (request.getNewValue() == null || request.getNewValue().isEmpty()){
            throw new InvalidRequestException("'New value' must not be null");
        }

        Socks updatedSocks = service.updateSocksBy(updatingId, request);
        return new SocksResponse(updatedSocks);
    }

    @Override
    @PostMapping("/batch")
    public SuccessFileReadingResponse csvBatch(CsvBatchRequest request) {

        if (!request.getCsvContent().isFile()){
            throw new InvalidRequestException("This is not file");
        }
        if (!request.getCsvContent().canRead()){
            throw new FileProcessingException("Reading file error");
        }

        service.csvBatch(request);

        return new SuccessFileReadingResponse("Success writing batches in database");
    }
}
