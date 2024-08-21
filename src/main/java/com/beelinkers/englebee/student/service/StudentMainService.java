package com.beelinkers.englebee.student.service;

import com.beelinkers.englebee.student.dto.response.StudentMainPageDTO;
import org.springframework.data.domain.Pageable;

public interface StudentMainService {
    StudentMainPageDTO getStudentMainPage(Long memberSeq, String code, Pageable pageable);
}
