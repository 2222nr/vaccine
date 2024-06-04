package com.example.vaccineManager.service;

import com.example.vaccineManager.dto.ReserveDto;
import com.example.vaccineManager.dto.VaccresvDto;
import com.example.vaccineManager.mapper.VaccineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VaccineService {
    @Autowired
    VaccineMapper vaccineMapper;

    public Long findNextVal() {
        Long nextVal = vaccineMapper.findNextVal();
        System.out.println(nextVal);
        return nextVal;
    }

    public void save(VaccresvDto vaccresvDto) {
        vaccineMapper.save(vaccresvDto);
    }

    public List<ReserveDto> findByResvNo() {
        return vaccineMapper.findByResvNo();
    }

    public List<ReserveDto> searchKeyword(String keyword) {
        Map<String, Object> params = new HashMap<>();
        params.put("keyword", keyword);
        boolean isNumber = keyword.matches("\\d+");
        boolean isDate = keyword.matches("\\d{4}-\\d{2}-\\d{2}");

        params.put("isNumber", isNumber);
        params.put("isDate", isDate);
        return vaccineMapper.searchKeyword(params);
    }

    public List<ReserveDto> status() {
        return vaccineMapper.status();
    }

    public void setVal() {
        vaccineMapper.setVal();
    }
}
