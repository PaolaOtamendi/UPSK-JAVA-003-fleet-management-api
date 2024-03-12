package com.fletmanagement.demo.repository;

import com.fletmanagement.demo.model.Taxi;
import com.fletmanagement.demo.model.Trajectories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TrajectoriesRepository extends JpaRepository<Trajectories, Long> {
    /*Page<Trajectories> findAll(Pageable pageable);*/
    // Este codigo solo es para prueba
    @Query("SELECT t FROM Trajectories t WHERE t.taxiId = :taxiId AND TO_CHAR(t.date, 'YYYY, MM, DD') = :date")
    public Page<Trajectories> findAll(@Param("taxiId") Integer taxiId, @Param("date") String date, Pageable pageable);
}
