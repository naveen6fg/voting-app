package com.nuchange.votingsystem.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.nuchange.votingsystem.model.Candidate;

@Service
public class VotingService {

	 private Map<String, Candidate> candidates= new HashMap<>();


	    public Boolean nominateCandidate(String candidateName){
	        if(!candidates.containsKey(candidateName)){
	            candidates.put(candidateName, new Candidate(candidateName, 0));
	            return Boolean.TRUE;
	        }
	        else
	            return Boolean.FALSE;
	    }


	   
}
