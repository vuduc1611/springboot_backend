package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QualificationRepository extends JpaRepository<Qualification, Long> {
}
