package com.abl.mydata.domain.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abl.mydata.domain.service.GitHubFeignService;
import com.abl.mydata.dto.Contributor;
import com.abl.mydata.feign.GitHubFeignClient;

@Service
public class GitHubFeignServiceImpl implements GitHubFeignService {
	@Autowired
	private GitHubFeignClient gitHubFeignClient;
	
	public List<Contributor> getContributor(String owner, String repo){
		List<Contributor> contributors = gitHubFeignClient.getContributor(owner, repo);
	    return contributors;
	}
}
