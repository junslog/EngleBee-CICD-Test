package com.beelinkers.englebee.student.service;

import com.beelinkers.englebee.student.dto.response.StudentMainPageDTO;

public interface StudentMainService {
    StudentMainPageDTO getStudentMainPage(Long memberSeq, String code);
}
