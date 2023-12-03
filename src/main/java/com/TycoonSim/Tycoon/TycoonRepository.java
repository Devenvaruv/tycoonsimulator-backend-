package com.TycoonSim.Tycoon;


import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;

import java.util.List;

public interface TycoonRepository extends DatastoreRepository<Tycoon, Long>  {

    List<Tycoon> findByScore(int score);
    //List<GameRecord> findByScore(int score);

}
