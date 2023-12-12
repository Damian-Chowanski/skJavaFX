package com.example.erpjavafx.dto;

import javafx.scene.shape.StrokeLineCap;
import lombok.Data;

@Data
public class OperatorAuthenticationResultDto {

    private long idOperator;
    private String firstName;
    private String lastName;
    private boolean authenticated;
}
