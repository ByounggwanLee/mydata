package com.abl.mydata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.abl.mydata.domain.service.GitHubFeignService;
import com.abl.mydata.dto.Contributor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class GitHubFeignController {
	@Autowired
	private GitHubFeignService gitHubFeignService;

	@GetMapping(value = "/v1/github/{owner}/{repo}")
	public List<Contributor> getGitHubContributors(@PathVariable String owner, @PathVariable String repo) {
		return gitHubFeignService.getContributor(owner, repo);
	}
}
