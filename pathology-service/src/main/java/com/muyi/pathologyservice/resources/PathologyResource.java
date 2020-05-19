package com.muyi.pathologyservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muyi.pathologyservice.models.Disease;
import com.muyi.pathologyservice.models.DiseasesList;

@RestController
@RequestMapping("/pathology")
public class PathologyResource {

	List<Disease> diseases = Arrays.asList(
		new Disease("D1","Malaria","Fever, headache, high temp","Chloroquine"),
		new Disease("D2","Asthma","Shorthness of breath","Warm water bath"),
		new Disease("D3","Thyfoid","Fever, shivering","Ampicilin capsules")
	);
	
	@GetMapping("/diseases")
	public DiseasesList getDiseases(){
		DiseasesList dl = new DiseasesList();
		dl.setDiseases(diseases);
		return dl;
	}
	
	@GetMapping("/diseases/{id}")
	public Disease getDiseaseById(@PathVariable("id") String id) {
		Disease ds = diseases.stream()
				.filter(d -> d.getId().equals(id)).findAny()
				.orElse(null);
		return ds;
	}
	
}
