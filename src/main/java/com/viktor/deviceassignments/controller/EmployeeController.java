package com.viktor.deviceassignments.controller;

import com.viktor.deviceassignments.repository.EmployeeRepository;
import com.viktor.deviceassignments.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

  private final EmployeeService employeeService;

  private final EmployeeRepository employeeRepository;

  @GetMapping
  public ResponseEntity<String> sayHello() {
    return ResponseEntity.ok("Hello from secured endpoint");
  }

//    private List<Asset> findAllAssetsByEmployee(EmployeeDto employeeDto) {
//       return employeeRepository.findAllAssetsByEmployee(employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getHireAt());
//    }

  // TODO view history of my asset assignment

  // TODO report lost/broken asset

  //TODO upload photo of broken asset

  //TODO create request for new asset

}
