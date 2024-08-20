package com.beelinkers.englebee.student.service.impl;

import com.beelinkers.englebee.general.domain.entity.Exam;
import com.beelinkers.englebee.general.domain.entity.ExamStatus;
import com.beelinkers.englebee.general.domain.entity.Lecture;
import com.beelinkers.englebee.general.domain.entity.Question;
import com.beelinkers.englebee.general.domain.repository.ExamRepository;
import com.beelinkers.englebee.general.domain.repository.LectureRepository;
import com.beelinkers.englebee.general.domain.repository.QuestionRepository;
import com.beelinkers.englebee.student.dto.response.*;
import com.beelinkers.englebee.student.service.StudentMainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class StudentMainServiceImpl implements StudentMainService {

    private final LectureRepository lectureRepository;
    private final QuestionRepository questionRepository;
    private final ExamRepository examRepository;

    @Autowired
    public StudentMainServiceImpl(
            LectureRepository lectureRepository,
            QuestionRepository questionRepository,
            ExamRepository examRepository
    ) {
        this.lectureRepository = lectureRepository;
        this.questionRepository = questionRepository;
        this.examRepository = examRepository;
    }

    @Override
    public StudentMainPageDTO getStudentMainPage(Long memberSeq, String code) {
        List<MainPageLectureDTO> lectureList;
        List<MainPageQuestionDTO> questionList;
        List<MainPageNewExamDTO> newExamList;
        List<MainPageSubmitExamDTO> submitExamList;

        if("STUDENT".equals(code)) {
            List<Lecture> lectures = lectureRepository.findByStudentSeq(memberSeq);
            lectureList = lectures.stream()
                    .map(lecture -> new MainPageLectureDTO(
                            lecture.getSeq(),
                            lecture.getTeacher().getSeq(),
                            lecture.getTitle(),
                            lecture.getStatus().name(),
                            lecture.getCreatedAt()
                    )).collect(Collectors.toList());

            List<Question> questions = questionRepository.findAll();
            questionList = questions.stream()
                    .map(question -> new MainPageQuestionDTO(
                            question.getSeq(),
                            question.getMember().getSeq(),
                            question.getTitle(),
                            question.getCreatedAt()
                    )).collect(Collectors.toList());

            List<Exam> newExams = examRepository.findByLectureStudentSeq(memberSeq);
            newExamList = newExams.stream()
                    .filter(exam -> exam.getStatus() == ExamStatus.PREPARED)
                    .map( exam -> new MainPageNewExamDTO(
                            exam.getSeq(),
                            exam.getLecture().getSeq(),
                            exam.getTitle(),
                            exam.getStatus().name()
                        )).collect(Collectors.toList());

            List<Exam> submitExams = examRepository.findByLectureStudentSeq(memberSeq);
            submitExamList = submitExams.stream()
                    .filter(exam -> exam.getStatus() == ExamStatus.SUBMITTED || exam.getStatus() == ExamStatus.FEEDBACK_COMPLETED)
                    .map(exam -> new MainPageSubmitExamDTO(
                            exam.getSeq(),
                            exam.getLecture().getSeq(),
                            exam.getStatus().name(),
                            exam.getTitle()
                    )).collect(Collectors.toList());
        } else {
            throw new IllegalArgumentException("접속하신 코드가 일치하지 않습니다. 해당코드 : "+code);
        }
        return new StudentMainPageDTO(lectureList, questionList, newExamList, submitExamList );
    }


}
