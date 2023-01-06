package com.abl.mydata.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.abl.mydata.dto.Contributor;

//---------------------------------------------------------------------
// 인터페이스를 생성하고 @FeignClient 어노테이션을 설정합니다.
// name 속성에는 페인 클라이언트의 이름을 설정하고, url 속성에는 호출할 api의 url을 설정합니다.
//----------------------------------------------------------------------
@FeignClient(name="feign", url="${prop.github.url}")
public interface GitHubFeignClient {
    @RequestMapping(method = RequestMethod.GET , value = "/{owner}/{repo}/contributors")
    List<Contributor> getContributor(@PathVariable("owner") String owner, @PathVariable("repo") String repo);
}