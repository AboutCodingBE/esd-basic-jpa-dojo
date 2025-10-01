package be.aboutcoding.jpadojo.entityrelations.onetoone.domain.employeebadge;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "badges")
public class Badge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "badge_number")
    private String badgeNumber;

    @Column(name = "access_level")
    private String accessLevel;

    @Column(name = "issue_date")
    private String issueDate;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "currentBadge")
    private Employee assignedEmployee;
}