package org.anyonetoo.anyonetoo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CommonResponseDTO {
    private String message;
    private int statusCode;
}
