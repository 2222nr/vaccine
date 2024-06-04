package com.example.vaccineManager.mapper;

import com.example.vaccineManager.dto.ReserveDto;
import com.example.vaccineManager.dto.VaccresvDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

@Mapper
public interface VaccineMapper {
    Long findNextVal();

    void save(@Param("vaccresvDto") VaccresvDto vaccresvDto);

    List<ReserveDto> findByResvNo();

    List<ReserveDto> searchKeyword(Map<String, Object> params);

    List<ReserveDto> status();

    void setVal();
}
