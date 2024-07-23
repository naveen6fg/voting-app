package com.nuchange.votingsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Candidate {

	private String name;
	private int voteCount;

}
