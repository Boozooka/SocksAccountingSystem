package boozooka.ru.SocksAccountingSystem.mvc.controll.services;

import boozooka.ru.SocksAccountingSystem.exceptions.FileProcessingException;
import boozooka.ru.SocksAccountingSystem.exceptions.InvalidRequestException;
import boozooka.ru.SocksAccountingSystem.exceptions.SocksNotFoundException;
import boozooka.ru.SocksAccountingSystem.exceptions.SocksShortageException;
import boozooka.ru.SocksAccountingSystem.mvc.controll.interfaces.services.SockAccountingServiceInterface;
import boozooka.ru.SocksAccountingSystem.mvc.controll.repositories.SocksJpaRepository;
import boozooka.ru.SocksAccountingSystem.mvc.models.Socks;
import boozooka.ru.SocksAccountingSystem.mvc.view.dto.requests.*;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Service
public class SockAccountingService implements SockAccountingServiceInterface {

    @Autowired
    SocksJpaRepository socksRepository;

    @Override
    public Socks socksIncome(SockIncomeRequest request) {
        Socks currentSocks = socksRepository.findByColorAndCottonPercentage(
                request.getColor(),
                request.getCottonPercentage()
        );

        if (currentSocks == null) {
            currentSocks = new Socks();
            currentSocks.setColor(request.getColor());
            currentSocks.setCount(request.getCount());
            currentSocks.setCottonPercentage(request.getCottonPercentage());
        } else {
            currentSocks.addCount(request.getCount());
        }

        socksRepository.save(currentSocks);

        return currentSocks;
    }

    @Override
    public Socks socksOutcome(SockOutcomeRequest request) {
        Socks currentSocks = socksRepository.findByColorAndCottonPercentage(
                request.getColor(),
                request.getCottonPercentage()
        );

        if (currentSocks == null) {
            throw new SocksNotFoundException("There is not this socks: color - "
                    + request.getColor() + ", cotton percentage - "
                    + request.getCottonPercentage());
        } else if (!currentSocks.reduceCount(request.getCount())) {
            throw new SocksShortageException("Not enough this socks: color - "
                    + request.getColor() + ", cotton percentage - "
                    + request.getCottonPercentage());
        } else {
            socksRepository.save(currentSocks);
            return currentSocks;
        }
    }

    @Override
    public Integer getSocksBy(GetAmountOfFilterSocksRequest request) {
        List<Socks> samples = socksRepository.findAllByColorAndCottonPercentage(
                request.getColor(),
                request.getCottonPercentage()
        );

        if (request.getCountEquals() != null) {
            samples = samples.stream()
                    .filter(x -> x.getCount() == request.getCountEquals())
                    .toList();
        }

        if (request.getCountLessThan() != null) {
            samples = samples.stream()
                    .filter(x -> x.getCount() < request.getCountLessThan())
                    .toList();
        }

        if (request.getCountMoreThan() != null) {
            samples = samples.stream()
                    .filter(x -> x.getCount() > request.getCountMoreThan())
                    .toList();
        }

        return samples.size();
    }

    @Override
    public Socks updateSocksBy(Long updatingId, SocksUpdateRequest request) {
        Socks updatingSocks;

        try {
            updatingSocks = socksRepository.getReferenceById(updatingId);
        } catch (EntityNotFoundException ex) {
            throw new SocksNotFoundException("Not found socks with id '" + updatingId + "'");
        }

        switch (request.getUpdatingColumn()) {
            case "color":
                updatingSocks.setColor(request.getNewValue());
                break;

            case "cottonPercentage":
                try {
                    Integer newPercentage = Integer.valueOf(request.getNewValue());
                    updatingSocks.setCottonPercentage(newPercentage);
                } catch (NumberFormatException ex) {
                    throw new InvalidRequestException("Cotton percentage must be number");
                }
                break;

            case "count":
                try {
                    Integer newCount = Integer.valueOf(request.getNewValue());
                    updatingSocks.setCottonPercentage(newCount);

                } catch (NumberFormatException ex) {
                    throw new InvalidRequestException("Count must be number");
                }
                break;

            default:
                throw new InvalidRequestException("Updating column can be 'color', " +
                        "'cottonPercentage' or 'count'");
        }
        socksRepository.save(updatingSocks);
        return updatingSocks;
    }

    @Override
    public boolean csvBatch(CsvBatchRequest request) {
        try (BufferedReader bufReader = new BufferedReader(new FileReader(request.getCsvContent()));
             CSVReader reader = new CSVReader(bufReader)) {

            List<String[]> material = reader.readAll();
            material.stream()
                    .forEach(arr -> {
                        String color = arr[0];
                        Integer cottonPercentage = Integer.valueOf(arr[1]);
                        Integer count = Integer.valueOf(arr[2]);

                        socksIncome(new SockIncomeRequest(color, cottonPercentage, count));
                    });

        } catch (IOException ex) {
            throw new InvalidRequestException("This file is invalid");
        } catch (CsvException ex) {
            throw new FileProcessingException("Some file-reading error occurred");
        }
        return false;
    }
}
