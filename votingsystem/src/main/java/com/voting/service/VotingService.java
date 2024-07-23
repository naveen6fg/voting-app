package com.voting.service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.voting.model.Candidate;

@Service
public class VotingService {

	private Map<String, Candidate> candidates = new ConcurrentHashMap();

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
	public Map<String, Integer> getWinner(){
        return candidates.entrySet().stream()
                    .max(Map.Entry.comparingByValue(Comparator.comparingInt(Candidate::getVoteCount)))
                    .map(entry -> Map.of(entry.getKey(), entry.getValue().getVoteCount()))
                    .orElse(null);

    }
}
