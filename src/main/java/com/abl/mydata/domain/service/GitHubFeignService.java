package com.abl.mydata.domain.service;

import java.util.List;

import com.abl.mydata.dto.Contributor;

public interface GitHubFeignService {
	List<Contributor> getContributor(String owner, String repo);
}
