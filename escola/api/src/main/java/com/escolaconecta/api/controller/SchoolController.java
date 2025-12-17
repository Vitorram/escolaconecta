package com.escolaconecta.api.controller;

import com.escolaconecta.api.model.SchoolEvent;
import com.escolaconecta.api.repository.SchoolEventRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schools")
public class SchoolController {

    private final SchoolEventRepository schoolEventRepository;

    public SchoolController(SchoolEventRepository schoolEventRepository) {
        this.schoolEventRepository = schoolEventRepository;
    }

    // Rota: GET /schools/{id}/events
    // Exemplo: O app chama isso para preencher a Home da escola selecionada
    @GetMapping("/{schoolId}/events")
    public List<SchoolEvent> getSchoolEvents(@PathVariable Long schoolId) {
        return schoolEventRepository.findBySchoolIdOrderByDateDesc(schoolId);
    }
}