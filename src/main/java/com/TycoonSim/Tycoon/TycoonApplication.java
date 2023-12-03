package com.TycoonSim.Tycoon;

import com.google.api.client.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

@ShellComponent
@SpringBootApplication
public class TycoonApplication {
	@Autowired
	TycoonRepository tycoonRepository;

	public static void main(String[] args) {
		SpringApplication.run(TycoonApplication.class, args);
	}

	@ShellMethod("Saves a TycoonRecord to Cloud Datastore: save-tycoonRecord <handle> <score> <date>")
	public String saveTycoonRecord(String handle, int score , String date) {
		Tycoon savedTycoon = this.tycoonRepository.save(new Tycoon(handle ,score , date ));
		return savedTycoon.toString();
	}

	@ShellMethod("Loads all TycoonRecord")
	public String findAllTycoonRecord() {
		Iterable<Tycoon> tycoonRecords = this.tycoonRepository.findAll();
		return Lists.newArrayList(tycoonRecords).toString();
	}

//	@ShellMethod("Loads record by user: find-by-userID <userId>")
//	public String findByUserId(String userId) {
//		List<Tycoon> tycoons = this.tycoonRepository.findByUserId(userId);
//		return tycoons.toString();
//	}

	@ShellMethod("remove all records")
	public void removeAllTycoonRecords() {
		this.tycoonRepository.deleteAll();
	}


}
