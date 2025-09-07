package be.aboutcoding.jpadojo.entityrelations.onetoone.repository;

import be.aboutcoding.jpadojo.entityrelations.onetoone.domain.employeebadge.Badge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BadgeRepository extends JpaRepository<Badge, Long> {

}