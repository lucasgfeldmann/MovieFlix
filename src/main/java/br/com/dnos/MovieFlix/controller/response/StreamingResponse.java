package br.com.dnos.MovieFlix.controller.response;

import lombok.Builder;

@Builder
public record StreamingResponse(Long id, String name) {
}
