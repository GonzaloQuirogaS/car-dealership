package com.app.cardealership.dto;

import java.io.Serializable;

//DTO de la clase Order que devuelve unicamente los valores necesarios para guardar un Order nuevo
public class SaveOrderDto implements Serializable {

    private String order_number;
    private Double order_total;

}
