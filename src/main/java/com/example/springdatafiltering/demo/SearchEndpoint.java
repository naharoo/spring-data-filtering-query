package com.example.springdatafiltering.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/applicants")
public class SearchEndpoint {

  private final ApplicantRepository repository;

  public SearchEndpoint(ApplicantRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/search")
  public Page<Applicant> search(
      @RequestParam(value = "name", required = false) String name,
      @RequestParam(value = "email", required = false) String email,
      @RequestParam(value = "courseId", required = false) Long courseId,
      Pageable pageable) {
    return repository.search(name, email, courseId, pageable);
  }
}
