package com.voting.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.voting.model.Candidate;

public class VotingServiceTest {

	private VotingService service;

	@BeforeEach
	private void setup() {
		service = new VotingService();
	}

	@Test
	public void testCandidateNomination() {
		assertTrue(service.nominateCandidate("ajay"));
		assertFalse(service.nominateCandidate("ajay"));
	}

	@Test
	void testCastVote() {
		service.castVote("Alice");
		assertEquals(1, service.castVote("Alice"));
		assertEquals(2, service.castVote("Alice"));
	}

	@Test
	void testCastVoteInvalidCandidate() {
		assertEquals(-1, service.castVote("Invalid"));
	}

	@Test
	void testCountVote() {
		service.countVote("Bob");
		service.castVote("Bob");
		assertEquals(1, service.countVote("Bob"));
	}

	@Test
	void testCountVoteInvalidCandidate() {
		assertEquals(-1, service.countVote("Invalid"));
	}

	@Test
	void testListCandidates() {
		service.nominateCandidate("ajay");
		service.nominateCandidate("Naveen");
		service.castVote("ajay");
		service.castVote("ajay");
		service.castVote("Naveen");
		
		assertEquals(2, service.countVote("ajay"));
		assertEquals(1, service.countVote("Naveen"));
	}

	@Test
	void testGetWinner() {
		service.nominateCandidate("ajay");
		service.nominateCandidate("Naveen");
		
		service.castVote("ajay");
		service.castVote("ajay");
		service.castVote("naveen");
		assertNotNull(service.getWinner());
	}

	@Test
	void testGetWinnerNoVotes() {
		assertNull(service.getWinner());
	}
}
