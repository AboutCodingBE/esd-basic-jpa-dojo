package be.aboutcoding.jpadojo.entityrelations.onetomany.domain.school;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "classes")
public class SchoolClass {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "class_name")
    private String className;

    @Column(name = "teacher")
    private String teacher;

    @Column(name = "room")
    private String room;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Child> children = new ArrayList<>();

    public void setChildren(List<Child> children) {
        this.children.clear();
        this.children.addAll(children);
    }

}