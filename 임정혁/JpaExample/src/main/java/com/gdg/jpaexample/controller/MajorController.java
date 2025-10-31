package com.gdg.jpaexample.controller;

import com.gdg.jpaexample.dto.MajorInfoResponseDto;
import com.gdg.jpaexample.dto.MajorSaveRequestDto;
import com.gdg.jpaexample.service.MajorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/majors")
public class MajorController {

    private final MajorService majorService;

    @PostMapping
    public ResponseEntity<MajorInfoResponseDto> saveMajor(@RequestBody MajorSaveRequestDto majorSaveRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(majorService.saveMajor(majorSaveRequestDto));
    }

    @DeleteMapping("/{majorId}")
    public ResponseEntity<Void> deleteMajorById(@PathVariable Long majorId) {
        majorService.deleteMajor(majorId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

