package com.example.Hoshpital.Management.System;

import com.example.Hoshpital.Management.System.entity.Patient;
import com.example.Hoshpital.Management.System.entity.type.BloodGroupType;
import com.example.Hoshpital.Management.System.modal.PatientDto;
import com.example.Hoshpital.Management.System.service.PatientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatient() {
        // ---> Create patient test
        PatientDto patientDto = new PatientDto();
        patientDto.setName("Prateek Singh");
        patientDto.setGender("Male");
        patientDto.setEmail("prateek@example.com");
        patientDto.setAge("22");
        patientDto.setBirthDate(LocalDate.of(2003, 12, 1));
        patientDto.setBloodGroupType(BloodGroupType.B_Positive);

        PatientDto patientDtoCreate = patientService.addPatientData(patientDto);
        System.out.println("After create patient data: " + patientDtoCreate);

        Assertions.assertNotNull(patientDtoCreate.getId());
        Assertions.assertEquals("Prateek Singh", patientDtoCreate.getName());
        Assertions.assertEquals("Male", patientDtoCreate.getGender());
        Assertions.assertEquals("prateek@example.com", patientDtoCreate.getEmail());
        Assertions.assertEquals("22", patientDtoCreate.getAge());
        Assertions.assertEquals(LocalDate.of(2003, 12, 1), patientDtoCreate.getBirthDate());
        Assertions.assertEquals(BloodGroupType.B_Positive, patientDtoCreate.getBloodGroupType());

        // ---> get all patient data
        List<PatientDto> patientList = patientService.getAllPatient();
        System.out.println(patientList);
        Assertions.assertNotNull(patientList);
        Assertions.assertFalse(patientList.isEmpty());

        // ---> Update patient data
        PatientDto patientUpdate = new PatientDto();
        patientUpdate.setName("Priyanshu");
        patientUpdate.setAge("21");
        patientUpdate.setGender("Male");
        patientUpdate.setEmail("priyansh23@example.com");


        PatientDto patientDtoUpdate = patientService.updatePatientData(patientDtoCreate.getId(), patientUpdate);
        System.out.println("update patient: " + patientDtoUpdate);

        Long invalid_id = 999L;
        Assertions.assertEquals(patientDtoCreate.getId(), patientDtoUpdate.getId());
        Assertions.assertEquals("Priyanshu", patientDtoUpdate.getName());
        Assertions.assertEquals("21", patientDtoUpdate.getAge());
        Assertions.assertEquals("Male", patientDtoUpdate.getGender());
        Assertions.assertEquals("priyansh23@example.com", patientDtoUpdate.getEmail());
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            patientService.getPatientById(invalid_id);
        });



        // ---> partial update patient data
        Map<String, Object> updates = new HashMap<>();
        updates.put("name", "Priyansh");
        updates.put("gender", "female");
        PatientDto partialUpdate = patientService.partialUpdateData(patientDtoCreate.getId(), updates);
        System.out.println("get patient by partial update: " + partialUpdate);
        Assertions.assertEquals("Priyansh", partialUpdate.getName());
        Assertions.assertEquals("female", partialUpdate.getGender());
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            patientService.getPatientById(invalid_id);
        });

        // ---> get patient data by id
        PatientDto patientDataById = patientService.getPatientById(patientDtoCreate.getId());
        System.out.println("get patient by id: " + patientDataById);

        Assertions.assertEquals("Priyansh", patientDataById.getName());
        Assertions.assertEquals("female", patientDataById.getGender());
        Assertions.assertEquals("priyansh23@example.com", patientDataById.getEmail());
        Assertions.assertEquals("21", patientDataById.getAge());
//        Assertions.assertEquals(LocalDate.of(2003, 12, 1), patientDataById.getBirthDate());
//        Assertions.assertEquals(BloodGroupType.B_Positive, patientDataById.getBloodGroupType());
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            patientService.getPatientById(invalid_id);
        });


        // ---> delete patient data
        patientService.deletePatientData(patientDtoCreate.getId());
        System.out.println("patient deleted");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            patientService.getPatientById(invalid_id);
        });


    }
}







