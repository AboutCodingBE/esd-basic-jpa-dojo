package be.aboutcoding.jpadojo.entityrelations.onetomany;

import be.aboutcoding.jpadojo.entityrelations.onetomany.domain.school.Child;
import be.aboutcoding.jpadojo.entityrelations.onetomany.domain.school.SchoolClass;
import be.aboutcoding.jpadojo.entityrelations.onetomany.dto.school.ChildResponse;
import be.aboutcoding.jpadojo.entityrelations.onetomany.dto.school.ClassResponse;
import be.aboutcoding.jpadojo.entityrelations.onetomany.dto.school.CreateClassRequest;
import be.aboutcoding.jpadojo.entityrelations.onetomany.repository.school.ChildRepository;
import be.aboutcoding.jpadojo.entityrelations.onetomany.repository.school.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jpa/training/onetomany")
public class OneToManyController {

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private ChildRepository childRepository;

    @GetMapping("/class")
    public ResponseEntity<List<ClassResponse>> getAllClasses() {
        List<SchoolClass> classes = classRepository.findAll();
        List<ClassResponse> response = classes.stream()
                .map(ClassResponse::from)
                .toList();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/class")
    public ResponseEntity<ClassResponse> createOrUpdateClass(@RequestBody CreateClassRequest request) {
        // Convert DTO to entity
        SchoolClass schoolClass = convertToEntity(request);

        // Save entity (children should be saved automatically via cascade)
        SchoolClass savedClass = classRepository.save(schoolClass);

        // Convert back to response DTO
        ClassResponse response = ClassResponse.from(savedClass);
        return ResponseEntity.ok(response);
    }

    private SchoolClass convertToEntity(CreateClassRequest request) {
        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setClassName(request.className());
        schoolClass.setTeacher(request.teacher());
        schoolClass.setRoom(request.room());

        // Convert list of ChildRequest to list of Child entities
        List<Child> children = new ArrayList<>();
        if (request.children() != null) {
            for (CreateClassRequest.ChildRequest childRequest : request.children()) {
                Child child = new Child();
                child.setFirstName(childRequest.firstName());
                child.setLastName(childRequest.lastName());
                child.setAge(childRequest.age());
                child.setStudentNumber(childRequest.studentNumber());
                children.add(child);
            }
        }
        schoolClass.setChildren(children);

        return schoolClass;
    }

    @GetMapping("/child")
    public ResponseEntity<List<ChildResponse>> getAllChildren() {
        List<Child> children = childRepository.findAll();
        List<ChildResponse> response = children.stream()
                .map(ChildResponse::from)
                .toList();
        return ResponseEntity.ok(response);
    }
}
