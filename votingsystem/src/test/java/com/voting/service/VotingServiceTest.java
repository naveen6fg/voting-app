package com.voting.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VotingServiceTest {

	private VotingService service;
	
	@BeforeEach
	private void setup() {
		service= new VotingService();
	}
	
	@Test
	public void testCandidateNomination() {
		 assertTrue(service.nominateCandidate("ajay"));
		 assertFalse(service.nominateCandidate("ajay"));
	}
}
