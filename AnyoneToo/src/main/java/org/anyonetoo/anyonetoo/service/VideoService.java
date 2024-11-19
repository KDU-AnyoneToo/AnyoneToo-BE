package org.anyonetoo.anyonetoo.service;

import lombok.RequiredArgsConstructor;
import org.anyonetoo.anyonetoo.dto.KakaoVideoSearchResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class VideoService {
    @Value("${kakao.api.key}")
    private String apiKey;

    @Value("${kakao.api.base-url}")
    private String baseUrl;

    private final WebClient webClient = WebClient.builder().build();

//    public KakaoVideoSearchResponse search(String query) {
//        return webClient.get()
//                .uri(uriBuilder -> uriBuilder
//                        .path(baseUrl)
//                        .queryParam("query", query)
//                        .build())
//                .header("Authorization", "KakaoAK " + apiKey)
//                .retrieve()
//                .onStatus(status -> status.is4xxClientError() || status.is5xxServerError(),
//                        clientResponse -> {
//                            // 로그를 출력하여 오류를 확인
//                            System.out.println("Error response: " + clientResponse.statusCode());
//                            return clientResponse.createException();
//                        })
//                .bodyToMono(KakaoVideoSearchResponse.class)
//                .block();
//    }
public KakaoVideoSearchResponse search(String query) {
    String requestUrl = UriComponentsBuilder.fromHttpUrl(baseUrl)
            .queryParam("query", query)
            .toUriString();

    return webClient.get()
            .uri(requestUrl)
            .header("Authorization", "KakaoAK " + apiKey)
            .retrieve()
            .onStatus(status -> status.is4xxClientError() || status.is5xxServerError(),
                    clientResponse -> {
                        // 응답 상태 코드 출력
                        System.out.println("Error response: " + clientResponse.statusCode());
                        return clientResponse.createException();
                    })
            .bodyToMono(KakaoVideoSearchResponse.class)
            .block();
}

}
