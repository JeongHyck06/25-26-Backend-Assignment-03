package com.gdg.jpaexample.service;

import com.gdg.jpaexample.domain.Major;
import com.gdg.jpaexample.dto.MajorInfoResponseDto;
import com.gdg.jpaexample.dto.MajorSaveRequestDto;
import com.gdg.jpaexample.repository.MajorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MajorService {

    private final MajorRepository majorRepository;

    @Transactional
    public MajorInfoResponseDto saveMajor(MajorSaveRequestDto majorSaveRequestDto) {
        Major major = Major.builder()
                .name(majorSaveRequestDto.getName())
                .build();

        majorRepository.save(major);

        return MajorInfoResponseDto.from(major);
    }

    @Transactional
    public void deleteMajor(Long majorId) {
        Major major = majorRepository.findById(majorId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 전공입니다."));
        
        majorRepository.delete(major);
    }
}
