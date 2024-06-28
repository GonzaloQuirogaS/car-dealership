package com.app.cardealership.dto;

import com.app.cardealership.persistance.entities.Car;
import com.app.cardealership.persistance.entities.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveOrderDetailDto implements Serializable {


    private String user_name;
    private String user_surname;
    private String email;
    private Long phone;

}
