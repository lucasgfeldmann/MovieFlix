package br.com.dnos.MovieFlix.controller;

import br.com.dnos.MovieFlix.controller.request.StreamingRequest;
import br.com.dnos.MovieFlix.controller.response.StreamingResponse;
import br.com.dnos.MovieFlix.mapper.StreamingMapper;
import br.com.dnos.MovieFlix.service.StreamingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movieflix/streaming")
@RequiredArgsConstructor
public class StreamingController {

    private final StreamingService streamingService;

    @GetMapping
    public ResponseEntity<List<StreamingResponse>> getAllCategories() {
        return ResponseEntity.ok(streamingService.findAll().stream().map(StreamingMapper::toStreamingResponse).toList());
    }

    @PostMapping
    public ResponseEntity<StreamingResponse> saveStreaming(@RequestBody StreamingRequest streaming) {
        return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.toStreamingResponse(streamingService.saveStreaming(StreamingMapper.toStreaming(streaming))));
    }

    @GetMapping("{id}")
    public ResponseEntity<StreamingResponse> getByStreamingId(@PathVariable Long id) {
        return streamingService.findById(id).map(streaming -> ResponseEntity.ok().body(StreamingMapper.toStreamingResponse(streaming))).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteByStreamingId(@PathVariable Long id) {
        streamingService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
