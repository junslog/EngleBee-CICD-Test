package com.beelinkers.englebee.teacher.controller.api;

import com.beelinkers.englebee.teacher.service.TeacherExamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/teacher/exam")
public class TeacherExamApiController {

  private final TeacherExamService teacherExamService;
}