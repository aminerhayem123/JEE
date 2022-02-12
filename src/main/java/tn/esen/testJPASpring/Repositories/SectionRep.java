package tn.esen.testJPASpring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esen.testJPASpring.model.Section;

@Repository
public interface SectionRep extends JpaRepository<Section, Long> {

}
