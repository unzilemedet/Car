package com.unzile.repository;

import com.unzile.repository.entity.CarColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarColorRepository extends JpaRepository<CarColor,Long> {
}
