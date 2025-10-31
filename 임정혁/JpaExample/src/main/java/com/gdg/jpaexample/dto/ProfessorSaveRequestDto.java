package com.gdg.jpaexample.dto;

import lombok.Getter;

@Getter
public class ProfessorSaveRequestDto {
    private Long majorId;
    private String name;
    private String email;
}
