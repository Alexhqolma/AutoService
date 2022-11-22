package com.example.autoservice.dto.response;

import com.example.autoservice.model.Status;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
public class OrderResponseDto {
    private Long id;
    private Long carId;
    private String problemDescription;
    private LocalDate startDate;
    private List<Long> carServicesId;
    private List<Long> productsId;
    private Status status;
    private double price;
    private LocalDate finishDate;
}
