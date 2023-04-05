package com.unzile.repository;

import com.unzile.dto.request.SaveCarRequestDto;
import com.unzile.mapper.ICarMapper;
import com.unzile.repository.entity.Car;
import org.mapstruct.factory.Mappers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICarRepository extends JpaRepository<Car,Long> {

    List<Car> findAllByNameContainingIgnoreCase(String name);
    List<Car> findAllByAdContaining(String name);

    @Query(value = "select * from tblcar as car\n" +
            "inner join tblcarcolor as cc on car.carid = cc.carid\n" +
            "where cc.colorid = ?1", nativeQuery = true)
    List<Car> findCarsByColor(Long colorId);
}


