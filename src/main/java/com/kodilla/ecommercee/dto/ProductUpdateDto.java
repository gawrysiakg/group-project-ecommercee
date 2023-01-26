package com.kodilla.ecommercee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class ProductUpdateDto {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private long qty;
    private boolean isObsolete;
    private String groupId;
}
