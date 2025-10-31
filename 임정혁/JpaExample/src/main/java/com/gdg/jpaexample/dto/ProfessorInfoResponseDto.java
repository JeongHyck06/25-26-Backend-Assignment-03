package com.gdg.jpaexample.dto;

import com.gdg.jpaexample.domain.Professor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProfessorInfoResponseDto {
    private Long id;
    private String name;
    private String email;
    private Long majorId;
    private String majorName;

    public static ProfessorInfoResponseDto from(Professor professor) {
        return ProfessorInfoResponseDto.builder()
                .id(professor.getId())
                .name(professor.getName())
                .email(professor.getEmail())
                .majorId(professor.getMajor().getId())
                .majorName(professor.getMajor().getName())
                .build();
    }
}
