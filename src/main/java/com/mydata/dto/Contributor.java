package com.mydata.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Github Contributor정보")
public class Contributor {
	@Schema(description = "로그인ID", nullable = false)
    String login;
	@Schema(description = "ID", nullable = false)
    String id;
	@Schema(description = "node_id", nullable = false)
    String node_id;
	@Schema(description = "avatar_url", nullable = false)
    String avatar_url;
	@Schema(description = "gravatar_id", nullable = false)
    String gravatar_id;
	@Schema(description = "url", nullable = false)
    String url;
	@Schema(description = "html_url", nullable = false)
    String html_url;
	@Schema(description = "followers_url", nullable = false)
    String followers_url;
	@Schema(description = "following_url", nullable = false)
    String following_url;
	@Schema(description = "gists_url", nullable = false)
    String gists_url;
	@Schema(description = "starred_url", nullable = false)
    String starred_url;
	@Schema(description = "subscriptions_url", nullable = false)
    String subscriptions_url;
	@Schema(description = "organizations_url", nullable = false)
    String organizations_url;
    String repos_url;
    @Schema(description = "events_url", nullable = false)
    String events_url;
    @Schema(description = "received_events_url", nullable = false)
    String received_events_url;
    @Schema(description = "type", nullable = false)
    String type;
    @Schema(description = "site_admin", nullable = false)
    String site_admin;
    @Schema(description = "contributions", nullable = false)
    int contributions;
}
