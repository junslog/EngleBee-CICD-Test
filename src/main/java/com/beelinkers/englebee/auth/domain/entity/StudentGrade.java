package com.beelinkers.englebee.auth.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StudentGrade {

  SEVENTH_GRADE("중1"),
  EIGHTH_GRADE("중2"),
  NINTH_GRADE("중3"),
  TENTH_GRADE("고1"),
  ELEVENTH_GRADE("고2"),
  TWELFTH_GRADE("고3");

  private final String koreanGrade;
}