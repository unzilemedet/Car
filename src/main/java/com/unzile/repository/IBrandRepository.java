package com.unzile.repository;

import com.unzile.repository.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IBrandRepository extends JpaRepository<Brand,Long> {



}
