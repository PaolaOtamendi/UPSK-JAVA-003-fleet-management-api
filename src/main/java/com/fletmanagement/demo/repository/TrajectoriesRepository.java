package com.fletmanagement.demo.repository;

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
    @Query(value = "SELECT * FROM trajectories t WHERE t.taxi_id = :taxiId AND TO_CHAR(t.date, 'YYYY-MM-DD') = :date ", nativeQuery = true)
    public Page<Trajectories> findTaxiHistoryByTaxiIdAndDate(@Param("taxiId") Integer taxiId, @Param("date") String date, Pageable pageable);

    @Query(value = "SELECT t.id, t.taxi_id, t.latitude, t.longitude, t.date" +
    " FROM trajectories t" + " WHERE t.date IN (SELECT MAX(date) FROM trajectories GROUP BY taxi_id) " + "ORDER BY t.date DESC", nativeQuery = true)
    public Page<Trajectories> findLatestTaxiLocations(Pageable pageable);
}
