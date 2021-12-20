package com.proretention.service;

import java.util.List;

import com.proretention.dto.BranchesDto;


public interface BranchesService {

	BranchesDto createBranches(BranchesDto branchesDto);

	BranchesDto getByBranchKey(String branchKey);

	void deleteByBranchKey( String branchKey);

	BranchesDto updateBranch( String branchKey ,BranchesDto userDtoes);

	List<BranchesDto> getBranches(int page, int limit);

}
