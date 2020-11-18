package com.ibm.bootcamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.bootcamp.entity.CurrencyConvertor;



@Repository
public interface CurrencyConvertorRepository extends JpaRepository<CurrencyConvertor, String>{

}
