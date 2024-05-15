package br.com.companyprogramming.apicourses.modules.courses.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.companyprogramming.apicourses.modules.courses.CoursesEntity;
import br.com.companyprogramming.apicourses.modules.courses.dto.CourseDTO;
import br.com.companyprogramming.apicourses.modules.courses.services.CourseService;

@RestController
@RequestMapping("/cursos")
public class CourseController {

  @Autowired
  private CourseService courseService;

  @PostMapping("/")
  public CoursesEntity create(@RequestBody CourseDTO courseDTO) {
    return courseService.createCourse(courseDTO);
  }

  @GetMapping("/")
  public List<CoursesEntity> findAll(@RequestParam(required = false) String name,
      @RequestParam(required = false) String category) {
    return courseService.getAllCourses(name, category);
  }

  @PutMapping("/{id}")
  public ResponseEntity<CoursesEntity> update(@PathVariable UUID id, @RequestBody CourseDTO updatedCourseDTO) {
    CoursesEntity updatedEntity = courseService.updateCourse(id, updatedCourseDTO);
    if (updatedEntity != null) {
      return ResponseEntity.ok(updatedEntity);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<CoursesEntity> delete(@PathVariable UUID id) {
    CoursesEntity deletedEntity = courseService.deleteCourse(id);

    if (deletedEntity != null) {
      return ResponseEntity.ok(deletedEntity);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PatchMapping("/{id}/active")
  public ResponseEntity<CoursesEntity> updateStatus(@PathVariable UUID id) {
    CoursesEntity updatedEntity = courseService.toggleCourseStatus(id);
    if (updatedEntity != null) {
      return ResponseEntity.ok(updatedEntity);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

}
