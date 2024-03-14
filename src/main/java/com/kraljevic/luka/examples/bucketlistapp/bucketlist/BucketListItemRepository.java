package com.kraljevic.luka.examples.bucketlistapp.bucketlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BucketListItemRepository extends JpaRepository<BucketListItem, Long> {

    List<BucketListItem> findByUsername(String username);
}
