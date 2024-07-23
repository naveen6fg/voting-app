package com.nuchange.votingsystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.nuchange.votingsystem.model.Candidate;

@Service
public class VotingService {

	private Map<String, Candidate> candidates = new HashMap<>();

	public Boolean nominateCandidate(String candidateName) {
		if (!candidates.containsKey(candidateName)) {
			candidates.put(candidateName, new Candidate(candidateName, 0));
			return Boolean.TRUE;
		} else
			return Boolean.FALSE;
	}

	public Boolean castVote(String name) {
		if (candidates.containsKey(name)) {
			candidates.get(name).setVoteCount(candidates.get(name).getVoteCount() + 1);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	public List<Candidate> getCandidates() {
		return candidates.values().stream().toList();
	}

	public Integer countVote(String name) {
		if (candidates.containsKey(name)) {
			return candidates.get(name).getVoteCount();
		}
		return null;
	}
}
