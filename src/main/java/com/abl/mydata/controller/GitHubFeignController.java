package com.abl.mydata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.abl.mydata.domain.service.GitHubFeignService;
import com.abl.mydata.dto.Contributor;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name = "feign Client통한 Git Hub Service 정보검색 Sample")
public class GitHubFeignController {
	@Autowired
	private GitHubFeignService gitHubFeignService;

	@Operation(summary = "Git Hub Owner와 Repository명으로 정보조회", description = "Git Hub 조회")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Found the hcallifhists", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Contributor.class)) }),
			 @ApiResponse(responseCode = "400", description = "Invalid id supplied", 
			    content = @Content), 
			 @ApiResponse(responseCode = "404", description = "Book not found", 
			    content = @Content)})
	@GetMapping(value = "/v1/github/{owner}/{repo}")
	public ResponseEntity<List<Contributor>> getGitHubContributors(
			@Parameter(description = "owner to be searched") @PathVariable String owner,
			@Parameter(description = "repository to be searched") @PathVariable String repo) {
		try {
			log.info("ResponseEntity<");
			return ResponseEntity.ok().body(gitHubFeignService.getContributor(owner, repo));
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		// return gitHubFeignService.getContributor(owner, repo);
	}
}
