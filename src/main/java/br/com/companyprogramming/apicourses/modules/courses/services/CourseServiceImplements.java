package br.com.companyprogramming.apicourses.modules.courses.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.companyprogramming.apicourses.modules.courses.CourseStatus;
import br.com.companyprogramming.apicourses.modules.courses.CoursesEntity;
import br.com.companyprogramming.apicourses.modules.courses.CoursesRepository;
import br.com.companyprogramming.apicourses.modules.courses.dto.CourseDTO;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CourseServiceImplements implements CourseService {
  @Autowired
  private CoursesRepository coursesRepository;

  @Override
  public CoursesEntity createCourse(CourseDTO courseDTO) {
    CoursesEntity coursesEntity = new CoursesEntity();
    coursesEntity.setName(courseDTO.getName());
    coursesEntity.setCategory(courseDTO.getCategory());
    return this.coursesRepository.save(coursesEntity);
  }

  @Override
  public List<CoursesEntity> getAllCourses(String name, String category) {
    if (name != null || category != null) {
      return this.coursesRepository.findByNameOrCategory(name, category);
    } else {
      return this.coursesRepository.findAll();
    }
  }

  @Override
  public CoursesEntity updateCourse(UUID id, CourseDTO updatedCourseDTO) {
    Optional<CoursesEntity> optionalCourse = coursesRepository.findById(id);
    if (optionalCourse.isPresent()) {
      CoursesEntity existingCourse = optionalCourse.get();
      if (updatedCourseDTO.getName() != null) {
        existingCourse.setName(updatedCourseDTO.getName());
      }
      if (updatedCourseDTO.getCategory() != null) {
        existingCourse.setCategory(updatedCourseDTO.getCategory());
      }
      return this.coursesRepository.save(existingCourse);
    } else {
      throw new EntityNotFoundException("Curso não encontrado com o ID: " + id);
    }
  }

  @Override
  public CoursesEntity deleteCourse(UUID id) {
    Optional<CoursesEntity> optionalCourse = coursesRepository.findById(id);
    if (optionalCourse.isPresent()) {
      CoursesEntity deletedCourse = optionalCourse.get();
      coursesRepository.deleteById(id);
      return deletedCourse;
    } else {
      throw new EntityNotFoundException("Curso não encontrado com o ID: " + id);
    }
  }

  @Override
  public CoursesEntity toggleCourseStatus(UUID id) {
    Optional<CoursesEntity> optionalCourse = coursesRepository.findById(id);
    if (optionalCourse.isPresent()) {
      CoursesEntity existingCourse = optionalCourse.get();
      existingCourse
          .setStatus(existingCourse.getStatus() == CourseStatus.ACTIVE ? CourseStatus.INACTIVE : CourseStatus.ACTIVE);
      return this.coursesRepository.save(existingCourse);
    } else {
      throw new EntityNotFoundException("Curso não encontrado com o ID: " + id);
    }
  }
}
