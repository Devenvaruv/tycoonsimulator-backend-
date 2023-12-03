package com.TycoonSim.Tycoon;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;

import java.util.List;

/**
 * Repository interface for interacting with Tycoon entities in Cloud Datastore.
 */
public interface TycoonRepository extends DatastoreRepository<Tycoon, Long> {

    /**
     * Finds Tycoon records by their score.
     *
     * @param score the score to search for
     * @return a list of Tycoon records with the specified score
     */
    List<Tycoon> findByScore(int score);
    //List<GameRecord> findByScore(int score);

}
