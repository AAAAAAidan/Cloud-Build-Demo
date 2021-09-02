package com.example.appengine.springboot;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.core.io.PathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringbootApplication.class, args);
  }

  @GetMapping("/")
  @ResponseBody
  public ResponseEntity<Resource> hello() {
    Path path = Paths.get(URI.create("gs://simple-library-media/covers/cover-default.png"));
    Resource resource = new PathResource(path.toUri());
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.IMAGE_PNG);
    return ResponseEntity.ok().headers(headers).body(resource);
  }

}
