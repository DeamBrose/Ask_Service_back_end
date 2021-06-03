package company.askservice.appweb.config.Error;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorInfo {
    private LocalDateTime timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

}
