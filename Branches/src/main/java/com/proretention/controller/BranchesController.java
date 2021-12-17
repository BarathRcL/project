package com.proretention.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proretention.dto.BranchesDto;
import com.proretention.request.BranchesRequest;
import com.proretention.responce.BranchesResponse;
import com.proretention.responce.OperationStatusModel;
import com.proretention.responce.RequestOperationStatus;
import com.proretention.service.BranchesService;

@RestController
@RequestMapping("/branches")
public class BranchesController {
	
	@Autowired
	BranchesService branchesService;
	
	@PostMapping("/")
	public BranchesResponse createBranches(@RequestBody BranchesRequest branchesRequest )
	{
		BranchesResponse branchesResponse =new BranchesResponse();
		
		BranchesDto branchesDto =new BranchesDto();
		
		BeanUtils.copyProperties(branchesRequest, branchesDto);
		
		BranchesDto createBranches=branchesService.createBranches(branchesDto);
		
        BeanUtils.copyProperties(createBranches, branchesResponse);
		
		return branchesResponse;
		
	}
	
	@GetMapping("/{id}")
	public BranchesResponse getBranch(@PathVariable("id") String branchKey)
	{
		BranchesResponse branchesResponse =new BranchesResponse();
		BranchesDto branchesDto =branchesService.getByBranchKey(branchKey);
		BeanUtils.copyProperties(branchesDto, branchesResponse);
		return branchesResponse;
	}
	
	@DeleteMapping("/{id}")
	public OperationStatusModel deleteByBranchId(@PathVariable("id")  String branchKey)
	{
		OperationStatusModel retVal = new OperationStatusModel();
		retVal.setOperationName(RequestOperationName.DELETE.name());
		
		 branchesService.deleteByBranchKey(branchKey);
		 retVal.setOperationResult(RequestOperationStatus.Success.name());
			return retVal;
	}

    @PutMapping("/{id}")
public BranchesResponse updateBranch( @PathVariable("id") String branchKey, @RequestBody BranchesRequest branches)
{

    	BranchesResponse retVal = new BranchesResponse();

    	BranchesDto userDto = new BranchesDto();
		BeanUtils.copyProperties(branches, userDto);

		BranchesDto updatedUser = branchesService.updateBranch(branchKey, userDto);
		BeanUtils.copyProperties(updatedUser, retVal);

		return retVal;
	
}
    @GetMapping("/")
	public List<BranchesResponse> getUsers(@RequestParam(value="page", defaultValue="1") int page, @RequestParam(value="limit", defaultValue="25") int limit) {
		List<BranchesResponse> retVal = new ArrayList<>();
		List<BranchesDto> branches = branchesService.getBranches(page,limit);
		
		for(BranchesDto branchDto : branches ) {
			BranchesResponse  branchModel = new BranchesResponse();
			BeanUtils.copyProperties(branchDto, branchModel);
			retVal.add(branchModel);
		}
		
		return retVal;
	}
}
	

	


