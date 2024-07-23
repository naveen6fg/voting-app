package com.voting.controller;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.voting.model.Candidate;
import com.voting.service.VotingService;

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

	@GetMapping("/listvote")
	public ResponseEntity<List<Candidate>> getCandidates() {
		return ResponseEntity.ok(votingService.getCandidates());
	}

	@GetMapping("/countvote")
	public ResponseEntity<Integer> countvote(@RequestParam String name) {
		Integer voteCount = votingService.countVote(name);
		return Objects.nonNull(voteCount) ? ResponseEntity.ok(voteCount) : ResponseEntity.badRequest().body(-1);
	}

	@GetMapping("/getwinner")
	public ResponseEntity<Map<String, Integer>> getWinner() {
		Map<String, Integer> winner = votingService.getWinner();
		if (Objects.nonNull(winner) && !winner.isEmpty()) {
			return ResponseEntity.ok(winner);
		} else {
			return ResponseEntity.badRequest().body(Map.of("No candidates found!", 0));
		}
	}
}
