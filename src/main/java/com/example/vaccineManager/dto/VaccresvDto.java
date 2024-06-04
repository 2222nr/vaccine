package com.example.vaccineManager.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccresvDto {
    private Long resv_no;
    @NotEmpty(message = "주민번호가 입력되지 않았습니다.")
    private String jumin;
    @NotEmpty(message = "병원코드가 선택되지 않았습니다.")
    private String hosp_code;
    @NotNull(message = "예약날짜가 입력되지 않았습니다.")
    @DateTimeFormat(pattern = "yyyyMMdd")
    private LocalDate resv_date;
    @NotNull(message = "예약시간이 입력되지 않았습니다.")
    @DateTimeFormat(pattern = "HHmm")
    private LocalTime resv_time;
    @NotEmpty(message = "백신코드가 선택되지 않았습니다.")
    private String v_code;
}
