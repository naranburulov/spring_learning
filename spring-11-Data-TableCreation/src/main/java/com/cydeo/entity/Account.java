package com.cydeo.entity;

import javax.persistence.*;
import java.math.BigDecimal;


@MappedSuperclass
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //creates id by postgres
    private Long id;
    private String owner;
    private BigDecimal balance;
    private BigDecimal interestRate;
}
