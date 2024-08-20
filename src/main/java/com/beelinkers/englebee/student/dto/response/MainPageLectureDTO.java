package com.beelinkers.englebee.student.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MainPageLectureDTO {
    private Long id;
    private Long teacherSeq;
    private String title;
    private String status;
    private LocalDateTime createdAt;

}
