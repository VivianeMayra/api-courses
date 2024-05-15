package br.com.companyprogramming.apicourses.modules.courses;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<CoursesEntity, UUID> {
  List<CoursesEntity> findByNameOrCategory(String name, String category);
}
