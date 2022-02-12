package tn.esen.testJPASpring.Repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esen.testJPASpring.model.Etudiant;

public interface EtudiantRep extends JpaRepository<Etudiant, Long>{ 
@Query ("select e from Etudiant e where e.nom like :x")
public Page<Etudiant> cherEtud(@Param("x")String mc,Pageable page); 
}
