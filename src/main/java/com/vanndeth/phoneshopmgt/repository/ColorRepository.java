package com.vanndeth.phoneshopmgt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vanndeth.phoneshopmgt.entity.Color;
@Repository
public interface ColorRepository extends JpaRepository<Color, Long>{

}
