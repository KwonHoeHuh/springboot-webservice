package com.spring.pj1.hkh.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HelloDto {
    private final String name;
    private final int amt;
}
