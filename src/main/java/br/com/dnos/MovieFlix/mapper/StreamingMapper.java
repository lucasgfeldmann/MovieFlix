package br.com.dnos.MovieFlix.mapper;

import br.com.dnos.MovieFlix.controller.request.StreamingRequest;
import br.com.dnos.MovieFlix.controller.response.StreamingResponse;
import br.com.dnos.MovieFlix.entity.Streaming;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamingMapper {
    public static Streaming toStreaming(StreamingRequest streamingRequest) {
        return Streaming.builder().name(streamingRequest.name()).build();
    }

    public static StreamingResponse toStreamingResponse(Streaming streaming) {
        return StreamingResponse.builder().id(streaming.getId()).name(streaming.getName()).build();
    }
}
