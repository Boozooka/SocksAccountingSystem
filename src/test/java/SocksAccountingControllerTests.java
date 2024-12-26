import boozooka.ru.SocksAccountingSystem.exceptions.FileProcessingException;
import boozooka.ru.SocksAccountingSystem.exceptions.InvalidRequestException;
import boozooka.ru.SocksAccountingSystem.mvc.controll.controllers.SockAccountingController;
import boozooka.ru.SocksAccountingSystem.mvc.controll.interfaces.controllers.SockAccountingControllerInterface;
import boozooka.ru.SocksAccountingSystem.mvc.view.dto.requests.*;
import configs.SocksAccountingControllerConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = ApplicationRunner.class)
@ContextConfiguration(classes = SocksAccountingControllerConfig.class)
public class SocksAccountingControllerTests {

    private final static Long VALID_ID = 1L;
    private final static Long INVALID_ID = null;

    private final static String VALID_STR_DATA = "ABUNGA";
    private final static String INVALID_STR_DATA = null;

    private final static Integer VALID_INT_DATA = 10;
    private final static Integer INVALID_INT_DATA = -1;

    @Autowired
    SockAccountingControllerInterface controller;

    @Test
    void socksIncomeOutcomeTest(){
        SockIncomeRequest request = new SockIncomeRequest(
                VALID_STR_DATA,
                VALID_INT_DATA,
                VALID_INT_DATA);
        
        assertDoesNotThrow(() -> controller.socksIncome(request));

        request.setColor(INVALID_STR_DATA);
        assertThrows(InvalidRequestException.class, () -> controller.socksIncome(request));
        request.setColor(VALID_STR_DATA);

        request.setCottonPercentage(INVALID_INT_DATA);
        assertThrows(InvalidRequestException.class, () -> controller.socksIncome(request));
        request.setCottonPercentage(VALID_INT_DATA);

        request.setCount(INVALID_INT_DATA);
        assertThrows(InvalidRequestException.class, () -> controller.socksIncome(request));
    }

    @Test
    void socksOutcomeTest(){
        SockOutcomeRequest request = new SockOutcomeRequest(
                VALID_STR_DATA,
                VALID_INT_DATA,
                VALID_INT_DATA);

        assertDoesNotThrow(() -> controller.socksOutcome(request));

        request.setColor(INVALID_STR_DATA);
        assertThrows(InvalidRequestException.class, () -> controller.socksOutcome(request));
        request.setColor(VALID_STR_DATA);

        request.setCottonPercentage(INVALID_INT_DATA);
        assertThrows(InvalidRequestException.class, () -> controller.socksOutcome(request));
        request.setCottonPercentage(VALID_INT_DATA);

        request.setCount(INVALID_INT_DATA);
        assertThrows(InvalidRequestException.class, () -> controller.socksOutcome(request));
    }
    /*private String color;
    private Integer cottonPercentage;
    private Integer countMoreThan;
    private Integer countLessThan;
    private Integer countEquals;*/
    @Test
    void socksGetByTest(){
        GetAmountOfFilterSocksRequest request = new GetAmountOfFilterSocksRequest(
                VALID_STR_DATA,
                VALID_INT_DATA,
                VALID_INT_DATA,
                VALID_INT_DATA,
                VALID_INT_DATA
        );

        assertDoesNotThrow(() -> controller.getSocksBy(request));

        request.setCottonPercentage(INVALID_INT_DATA);
        assertThrows(InvalidRequestException.class, () -> controller.getSocksBy(request));
        request.setCottonPercentage(VALID_INT_DATA);

        request.setCountEquals(INVALID_INT_DATA);
        assertThrows(InvalidRequestException.class, () -> controller.getSocksBy(request));
        request.setCountEquals(VALID_INT_DATA);

        request.setCountLessThan(INVALID_INT_DATA);
        assertThrows(InvalidRequestException.class, () -> controller.getSocksBy(request));
        request.setCountLessThan(VALID_INT_DATA);

        request.setCountMoreThan(INVALID_INT_DATA);
        assertThrows(InvalidRequestException.class, () -> controller.getSocksBy(request));
    }

    @Test
    void socksUpdateTest(){
        SocksUpdateRequest request = new SocksUpdateRequest(VALID_STR_DATA, VALID_STR_DATA);

        assertDoesNotThrow(() -> controller.updateSocksBy(VALID_ID, request));

        assertThrows(InvalidRequestException.class, () -> controller.updateSocksBy(INVALID_ID, request));

        request.setUpdatingColumn(INVALID_STR_DATA);
        assertThrows(InvalidRequestException.class, () -> controller.updateSocksBy(VALID_ID, request));
        request.setUpdatingColumn(VALID_STR_DATA);

        request.setNewValue(INVALID_STR_DATA);
        assertThrows(InvalidRequestException.class, () -> controller.updateSocksBy(VALID_ID, request));
    }

    @Test
    void socksCsvBatchTest(){
        CsvBatchRequest request = new CsvBatchRequest(new File("ТЗ.txt"));

        assertDoesNotThrow(() -> controller.csvBatch(request));

        request.setCsvContent(new File(".idea"));
        assertThrows(InvalidRequestException.class, () -> controller.csvBatch(request));
    }
}
