package com.fletmanagement.demo.repository;

import com.fletmanagement.demo.model.Trajectories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrajectoriesRepository extends JpaRepository<Trajectories, Long> {
    /*Page<Trajectories> findAll(Pageable pageable);*/
    // Este codigo solo es para prueba
    @Query(value = "SELECT * FROM trajectories t WHERE t.taxi_id = :taxiId AND TO_CHAR(t.date, 'YYYY-MM-DD') = :date ", nativeQuery = true)
    public Page<Trajectories> findTaxiHistoryByTaxiIdAndDate(@Param("taxiId") Integer taxiId, @Param("date") String date, Pageable pageable);


    @Query(value = "SELECT ID, TAXI_ID, date, LONGITUDE, LATITUDE\n" +
            "            FROM (\n" +
            "            SELECT ID, TAXI_ID, date, LONGITUDE, LATITUDE,\n" +
            "            ROW_NUMBER() OVER (PARTITION BY TAXI_ID ORDER BY date DESC) as row_num\n" +
            "            FROM public.TRAJECTORIES) AS ranked\n" +
            "            WHERE row_num = 1", nativeQuery = true)
    public List<Trajectories> findLatestTaxiLocations(Pageable pageable);
}
