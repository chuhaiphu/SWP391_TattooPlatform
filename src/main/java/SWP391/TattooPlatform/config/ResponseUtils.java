package SWP391.TattooPlatform.config;


import SWP391.TattooPlatform.model.ResponseDTO;
import lombok.experimental.UtilityClass;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.ConstraintViolationException;
import java.util.Collections;

@UtilityClass
public class ResponseUtils {
    public static ResponseEntity<ResponseDTO> get(Object result, HttpStatus status){
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .content(result)
                        .hasErrors(false)
                        .errors(Collections.emptyList())
                        .timestamp(DateTimeUtils.now())
                        .status(status.value())
                        .build()
                , status
        );
    }



    public static ResponseEntity<ResponseDTO> error(
            ConstraintViolationException exception, HttpStatus status){
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .content(null)
                        .hasErrors(true)
                        .errors(ExceptionUtils.getErrors(exception))
                        .timestamp(DateTimeUtils.now())
                        .status(status.value())
                        .build()
                , status
        );
    }

    public static ResponseEntity<ResponseDTO> error(RuntimeException exception, HttpStatus status) {
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .content(null)
                        .hasErrors(true)
                        .errors(ExceptionUtils.getErrors(exception))
                        .timestamp(DateTimeUtils.now())
                        .status(status.value())
                        .build()
                , status
        );
    }

    public static ResponseEntity<ResponseDTO> error(DataIntegrityViolationException exception, HttpStatus status) {
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .content(null)
                        .hasErrors(true)
                        .errors(ExceptionUtils.getErrors(exception))
                        .timestamp(DateTimeUtils.now())
                        .status(status.value())
                        .build()
                , status
        );
    }

    public static ResponseEntity<ResponseDTO> error(MethodArgumentNotValidException exception, HttpStatus status) {
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .content(null)
                        .hasErrors(true)
                        .errors(ExceptionUtils.getErrors(exception))
                        .timestamp(DateTimeUtils.now())
                        .status(status.value())
                        .build()
                , status
        );
    }

    public static ResponseEntity<ResponseDTO> returnResult(HttpStatus status) {
        return new ResponseEntity<> (
                ResponseDTO.builder()
                        .hasErrors(false)
                        .errors(Collections.emptyList())
                        .timestamp(DateTimeUtils.now())
                        .status(status.value())
                        .build()
                ,status
        );
    }

    public static ResponseEntity<?> error(String notAllowDuplicate, HttpStatus status) {
        return new ResponseEntity<> (
                ResponseDTO.builder()
                        .hasErrors(true)
                        .errors(ExceptionUtils.getError())
                        .timestamp(DateTimeUtils.now())
                        .status(status.value())
                        .build()
                ,status
        );
    }
}

