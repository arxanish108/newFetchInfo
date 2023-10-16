package com.manyTone.mapping.Repository;

import com.manyTone.mapping.Model.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicRepository extends JpaRepository<Clinic,Long> {
}
