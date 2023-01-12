package com.mydata.domain.service;

import java.util.List;

import com.mydata.dto.Contributor;

public interface GitHubFeignService {
	List<Contributor> getContributor(String owner, String repo);
}
