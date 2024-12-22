package boozooka.ru.SocksAccountingSystem.exceptions;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @Autowired
    Logger logger;

    @ExceptionHandler(InvalidRequestException.class)
    ResponseEntity<?> invalidRequest(InvalidRequestException ex) {
        logger.info(HttpStatus.BAD_REQUEST.value() + ": " + ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SocksNotFoundException.class)
    ResponseEntity<?> socksNotFound(SocksNotFoundException ex){
        logger.info(HttpStatus.NOT_FOUND.value() + ": " + ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FileProcessingException.class)
    ResponseEntity<?> fileProcessing(FileProcessingException ex){
        logger.info(HttpStatus.INTERNAL_SERVER_ERROR.value() + ": " + ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(SocksShortageException.class)
    ResponseEntity<?> socksShortage(SocksShortageException ex){
        logger.info(HttpStatus.NOT_FOUND.value() + ": " + ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

}
