package com.example.vaccineManager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReserveDto {
    // 예약번호, 성명, 성별, 병원이름, 예약날짜, 예약시간, 백신코드, 병원지역, 병원지역명, 접종예약건수
    private Long resv_no;
    private String name;
    private String jumin;
    private String hosp_code;
    private String hosp_name;
    private String hosp_addr;
    private LocalDate resv_date;
    private LocalTime resv_time;
    private String v_code;
    private Long resv_count;
}
