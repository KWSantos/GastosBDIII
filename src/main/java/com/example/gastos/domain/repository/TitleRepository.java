package com.example.gastos.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.gastos.domain.model.Title;
import com.example.gastos.domain.model.Users;

import java.util.List;

public interface TitleRepository extends JpaRepository<Title, Long>{
    
    @Query(nativeQuery = true, value = "SELECT * FROM public.title WHERE maturityDate BETWEEN TO_TIMESTAMP(:initialPeriod, 'YYYY-MM-DD hh24:MI;SS') AND TO_TIMESTAMP(:finalPeriod, 'YYYY-MM-DD hh24:MI:SS')")
    List<Title> getByMaturityDate(
        @Param("periodoInicial") String initialPeriod,
        @Param("periodoFInal") String finalPeriod
    );
    List<Title> findByUser(Users user);
}
