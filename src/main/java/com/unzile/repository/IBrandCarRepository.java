package com.unzile.repository;

import com.unzile.repository.entity.BrandCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBrandCarRepository extends JpaRepository<BrandCar,Long> {
    @Query("select bc. brandid from BrandCar bc where bc.carid =?1")
    List<Long> getAllByCarid(Long carid);
    List<BrandCar> findALLByCarid(Long carid);
}
