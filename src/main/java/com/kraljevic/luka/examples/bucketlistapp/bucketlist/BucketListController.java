package com.kraljevic.luka.examples.bucketlistapp.bucketlist;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class BucketListController {

    private final BucketListItemRepository bucketListItemRepository;

    public BucketListController(BucketListItemRepository bucketListItemRepository) {
        this.bucketListItemRepository = bucketListItemRepository;
    }

    @GetMapping("/users/{username}/bucket-list")
    public List<BucketListItem> getAllBucketListItems(@PathVariable String username) {
        return bucketListItemRepository.findByUsername(username);
    }

    @GetMapping("/users/{username}/bucket-list/{id}")
    public BucketListItem getBucketListItem(@PathVariable String username, @PathVariable long id) {
        return bucketListItemRepository.findById(id).orElse(null);
    }

    @PutMapping("/users/{username}/bucket-list/{id}")
    public ResponseEntity<BucketListItem> updateBucketListItem(@PathVariable String username, @PathVariable long id,
                                                               @RequestBody BucketListItem bucketListItem) {
        BucketListItem bucketListItemUpdated = saveBucketListItem(username, bucketListItem);
        return new ResponseEntity<>(bucketListItemUpdated, HttpStatus.OK);
    }

    @PostMapping("/users/{username}/bucket-list")
    public ResponseEntity<Void> createBucketListItem(@PathVariable String username, @RequestBody BucketListItem bucketListItem) {
        BucketListItem createdBucketListItem = saveBucketListItem(username, bucketListItem);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdBucketListItem.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    private BucketListItem saveBucketListItem(String username, BucketListItem bucketListItem) {
        bucketListItem.setUsername(username);
        return bucketListItemRepository.save(bucketListItem);
    }

    @DeleteMapping("/users/{username}/bucket-list/{id}")
    public ResponseEntity<Void> deleteBucketListItem(@PathVariable String username, @PathVariable long id) {
        bucketListItemRepository.deleteById(id);

        return ResponseEntity.noContent().build();

    }


}
