package company.askservice.appweb.config.Error;

import company.askservice.appweb.config.Error.exceptions.BadRequest;
import company.askservice.appweb.config.Error.exceptions.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionsHandlers {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NotFound.class})
    @ResponseBody
    public ErrorInfo NotFoundRequest(HttpServletRequest request, Exception exception){
        LocalDateTime timestamp = LocalDateTime.now();
        Integer status = HttpStatus.NOT_FOUND.value();
        String error = HttpStatus.NOT_FOUND.getReasonPhrase();
        String message = exception.getMessage();
        String path = request.getRequestURI();

        return new ErrorInfo(timestamp, status, error, message, path);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({BadRequest.class})
    @ResponseBody
    public ErrorInfo badRequest(HttpServletRequest request, Exception exception){
        LocalDateTime timestamp = LocalDateTime.now();
        Integer status = HttpStatus.BAD_REQUEST.value();
        String error = HttpStatus.BAD_REQUEST.getReasonPhrase();
        String message = exception.getMessage();
        String path = request.getRequestURI();

        return new ErrorInfo(timestamp, status, error, message, path);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public ErrorInfo fatalError(HttpServletRequest request, Exception exception){
        LocalDateTime timestamp = LocalDateTime.now();
        Integer status = HttpStatus.INTERNAL_SERVER_ERROR.value();
        String error = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
        String message = "Ingrese correctamente los datos. "+exception.getMessage();
        String path = request.getRequestURI();

        return new ErrorInfo(timestamp, status, error, message, path);
    }
}
