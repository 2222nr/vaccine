package com.example.vaccineManager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HospitalDto {
    private String hosp_code;
    private String hosp_name;
    private String hosp_tel;
    private String hosp_addr;
}
