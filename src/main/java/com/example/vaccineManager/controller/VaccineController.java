package com.example.vaccineManager.controller;

import com.example.vaccineManager.dto.ReserveDto;
import com.example.vaccineManager.dto.VaccresvDto;
import com.example.vaccineManager.service.VaccineService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
public class VaccineController {
    @Autowired
    VaccineService vaccineService;


    @GetMapping("/")
    public String main(){
        return "vaccine/index";
    }

    @GetMapping("/reserve")
    public String reserve(Model model){
        vaccineService.setVal();
        Long nextVal = vaccineService.findNextVal();
        VaccresvDto vaccresvDto = new VaccresvDto();
        vaccresvDto.setResv_no(nextVal);
        model.addAttribute("reserve", vaccresvDto);
        return "vaccine/reserve_vaccine";
    }

    @PostMapping("/reserve")
    public String insert(@Valid @ModelAttribute("reserve") VaccresvDto vaccresvDto,
                         BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "vaccine/reserve_vaccine";
        }
        vaccineService.save(vaccresvDto);
        return "redirect:/";
    }


    @GetMapping("/reserved_show")
    public String showOne(Model model){
        List<ReserveDto> reserveDto = vaccineService.findByResvNo();
        if(reserveDto == null){
            return "vaccine/null";
        } else {
            model.addAttribute("reserve", reserveDto);
            return "vaccine/reserved_show";
        }
    }

    @GetMapping("/reservation_status")
    public String showStatus(Model model){
        List<ReserveDto> reserveDtos = vaccineService.status();
        log.info(reserveDtos.toString());
        model.addAttribute("reserve", reserveDtos);
        return "vaccine/reservation_status";
    }

    @GetMapping("/reservation_search")
    public String search() {
        return "vaccine/reservation_search";
    }

    @GetMapping("/search")
    public String searchKeyword(@ModelAttribute(value="keyword") String keyword,
                                Model model){
        List<ReserveDto> reserveDtos = vaccineService.searchKeyword(keyword);
        log.info(reserveDtos.toString());
        if(reserveDtos.isEmpty()){
            return "vaccine/null";
        } else {
            model.addAttribute("reserve", reserveDtos);
            model.addAttribute("keyword", keyword);
            return "vaccine/reserved_show";
        }
    }


}
