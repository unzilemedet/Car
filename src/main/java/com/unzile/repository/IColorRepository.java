package com.unzile.repository;

import com.unzile.repository.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IColorRepository extends JpaRepository<Color,Long> {
    Optional<Color> findByNameIgnoreCase(String colorName);

}
