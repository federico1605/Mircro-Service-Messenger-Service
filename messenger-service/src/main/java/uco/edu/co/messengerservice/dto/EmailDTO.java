package uco.edu.co.messengerservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailDTO {
    private String message;
    private String user;
    private String title;
}
