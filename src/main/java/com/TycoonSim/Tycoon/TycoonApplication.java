package com.TycoonSim.Tycoon;

import com.google.api.client.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

/**
 * Main application class for Tycoon Application.
 */
@ShellComponent
@SpringBootApplication
public class TycoonApplication {

	@Autowired
	TycoonRepository tycoonRepository;

	/**
	 * Main method to run the Tycoon Application.
	 *
	 * @param args Command-line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(TycoonApplication.class, args);
	}

	/**
	 * Saves a TycoonRecord to Cloud Datastore.
	 *
	 * @param handle the handle of the Tycoon
	 * @param score  the score of the Tycoon
	 * @param date   the date of the Tycoon record
	 * @return a string representation of the saved Tycoon
	 */
	@ShellMethod("Saves a TycoonRecord to Cloud Datastore: save-tycoonRecord <handle> <score> <date>")
	public String saveTycoonRecord(String handle, int score, String date) {
		Tycoon savedTycoon = this.tycoonRepository.save(new Tycoon(handle, score, date));
		return savedTycoon.toString();
	}

	/**
	 * Loads all TycoonRecords.
	 *
	 * @return a string representation of all TycoonRecords
	 */
	@ShellMethod("Loads all TycoonRecord")
	public String findAllTycoonRecord() {
		Iterable<Tycoon> tycoonRecords = this.tycoonRepository.findAll();
		return Lists.newArrayList(tycoonRecords).toString();
	}

//    /**
//     * Loads records by user ID.
//     *
//     * @param userId the user ID to search for
//     * @return a string representation of Tycoon records for the given user ID
//     */
//    @ShellMethod("Loads record by user: find-by-userID <userId>")
//    public String findByUserId(String userId) {
//        List<Tycoon> tycoons = this.tycoonRepository.findByUserId(userId);
//        return tycoons.toString();
//    }

	/**
	 * Removes all Tycoon records.
	 */
	@ShellMethod("remove all records")
	public void removeAllTycoonRecords() {
		this.tycoonRepository.deleteAll();
	}
}
