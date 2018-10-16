package org.formation.ws;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

	Map<Long, Patient> patients = new HashMap<>();
	private long currentId = 123;
	
	
	
	public PatientServiceImpl() {
		init();
	}

	final void init() {
		Patient p = new Patient();
		p.setId(currentId);
		p.setName("Fabien");
		patients.put(p.getId(), p);
	}

//	public PatientServiceImpl() {
//		Patient p = new Patient();
//		p.setId(currentId);
//		p.setName("Fabien");
//		patients.put(p.getId(), p);
//	}

	@Override
	public Patient getPatient(String id) {
		Long longId = Long.valueOf(id);
		System.out.println("get patient "+longId);
		Patient patient = patients.get(longId);
		return patient;
	}

	@Override
	public List<Patient> getPatients() {
//		List<Patient> liste = new ArrayList<>();
//		liste = (List<Patient>) patients.values();	
//		return liste;
		return new ArrayList<>(patients.values());
	}

	@Override
	public Response updatePatient(Patient updatedPatient) {
		Patient patient = patients.get(updatedPatient.getId());
		Response response = null;
		if(patient != null) {
			patients.put(updatedPatient.getId(), updatedPatient);
			response = Response.ok(updatedPatient).build();
		}else {
			response = Response.notModified().build();
		}	
		return response;
	}

	@Override
	public Response addPatient(Patient patient) {
		patient.setId(++currentId);
		patients.put(patient.getId(), patient);
		return Response.ok(patient).build();
	}

	@Override
	public Response deletePatients(String id) {
		System.out.println("deletePatients "+id);
		Long longId = Long.valueOf(id);
		Patient patient = patients.get(longId);
		Response response = null;
		if(patient != null) {
			patients.remove(longId);
			response = Response.ok("Patient supprimé.").build();
		}else {
			response = Response.notModified().build();
		}	
		return response;
	}

}
