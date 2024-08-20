package com.beelinkers.englebee.student.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MainPageQuestionDTO {
    private Long seq;
    private Long memberSeq;
    private String title;
    private LocalDateTime createdAt;
}
