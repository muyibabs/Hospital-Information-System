package com.muyi.admissionservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.muyi.admissionservice.models.DiseasesList;
import com.muyi.admissionservice.models.EmployeesList;
import com.muyi.admissionservice.models.Patient;

@RestController
@RequestMapping("/admissions")
public class AdmissionsResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	List<Patient> patients = Arrays.asList(
			new Patient("P1","Mike", "Hungarian"),
			new Patient("P2","Andrew", "American"),
			new Patient("P3","Omolade", "Mexican"),
			new Patient("P4","Steve", "Nigerian")
		);
	
	@GetMapping("/physicians")
	public EmployeesList getPhysicians() {
		return restTemplate.getForObject("http://hr-service/hr/employees", EmployeesList.class);
	}
	
	@GetMapping("/diseases")
	public DiseasesList getDiseases() {
		return restTemplate.getForObject("http://pathology-service/pathology/diseases", DiseasesList.class);
	}
	
	@RequestMapping("/patients") //Same as @GetMapping("/patients")
	public List<Patient> getPatients(){
		return patients;
	}
	
	@RequestMapping("/patients/{id}")
	public Patient getPatientById(@PathVariable("id") String id) {
		Patient pp = patients.stream()
				.filter(pt -> pt.getId().equals(id)).findAny()
				.orElse(null);
		return pp;
	}
}
