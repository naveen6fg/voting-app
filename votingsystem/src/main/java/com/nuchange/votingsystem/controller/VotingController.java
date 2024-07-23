package com.nuchange.votingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nuchange.votingsystem.service.VotingService;

@RestController
public class VotingController {
	@Autowired
	private VotingService votingService;

	@PostMapping("/entercandidate")
	public ResponseEntity<String> candidateNomination(@RequestParam String name) {
		return votingService.nominateCandidate(name) ? ResponseEntity.ok("Candidate nomination completed successfully!")
				: ResponseEntity.badRequest().body("Candidate already exists");

	}

	@PostMapping("/castvote")
	public ResponseEntity<String> castVote(@RequestParam String name) {
		return votingService.castVote(name) ? ResponseEntity.ok("Vote casted!")
				: ResponseEntity.badRequest().body("Candidate doesn't exists!");
	}

}
