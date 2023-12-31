package com.currencyconversion.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Currency {
    private String type;
    private long value;
}
