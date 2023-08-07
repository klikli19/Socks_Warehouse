package pro.sky.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SocksNotFoundException extends RuntimeException {
    public SocksNotFoundException(String message) {
        super(message);
    }
}
