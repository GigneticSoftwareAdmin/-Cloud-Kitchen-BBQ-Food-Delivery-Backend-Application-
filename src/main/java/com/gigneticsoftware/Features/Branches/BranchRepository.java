package com.gigneticsoftware.Features.Branches;

import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BranchRepository extends JpaRepository<Branch, String> {
    // Spatial Query: Find branch that covers this location
    @Query("SELECT b FROM Branch b WHERE ST_Contains(b.serviceArea, :location) = true AND b.isOpen = true")
    Optional<Branch> findNearestBranch(Point location);
}
