package com.jackxue.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {
    private Integer id;
    private BigDecimal blance;
    private Integer status;
}
