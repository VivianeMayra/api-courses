package br.com.companyprogramming.apicourses.modules.courses.services;

import java.util.List;
import java.util.UUID;

import br.com.companyprogramming.apicourses.modules.courses.CoursesEntity;
import br.com.companyprogramming.apicourses.modules.courses.dto.CourseDTO;

public interface CourseService {
  CoursesEntity createCourse(CourseDTO courseDTO);

  List<CoursesEntity> getAllCourses(String name, String category);

  CoursesEntity updateCourse(UUID id, CourseDTO updaCourseDTO);

  CoursesEntity deleteCourse(UUID id);

  CoursesEntity toggleCourseStatus(UUID id);
}
