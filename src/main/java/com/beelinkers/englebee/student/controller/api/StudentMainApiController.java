package com.beelinkers.englebee.student.controller.api;

import com.beelinkers.englebee.general.controller.page.MainPageController;
import com.beelinkers.englebee.student.dto.response.StudentMainPageDTO;
import com.beelinkers.englebee.student.service.StudentMainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/student/main")
public class StudentMainApiController {

  private final StudentMainService studentMainService;

  @GetMapping("/qna")
  public ResponseEntity<StudentMainPageDTO> getMainPage(
          @RequestParam("memberSeq") Long memberSeq,
          @RequestParam("code") String code
  ) {
    StudentMainPageDTO studentMainPageDTO = studentMainService.getStudentMainPage(memberSeq, code);
    return ResponseEntity.ok(studentMainPageDTO);
  }

}
