package com.spring.pj1.hkh.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        String name = "test";
        int amt = 1000;

        HelloDto dto = new HelloDto(name, amt);

        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmt()).isEqualTo(amt);
    }
}
