package com.beelinkers.englebee.student.dto.response;

import com.beelinkers.englebee.general.dto.response.PaginationResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StudentMainPageDTO {
    private List<MainPageLectureDTO> lectureList;
    private List<MainPageQuestionDTO> questionList;
    private List<MainPageNewExamDTO> newExamList;
    private List<MainPageSubmitExamDTO> submitExamList;
    private PaginationResponseDTO questionPagination;
    private PaginationResponseDTO newExamPagination;
    private PaginationResponseDTO submitExamPagination;
}
