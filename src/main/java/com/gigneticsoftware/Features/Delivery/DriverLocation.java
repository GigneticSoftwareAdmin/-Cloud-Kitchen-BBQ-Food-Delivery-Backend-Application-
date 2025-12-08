package com.gigneticsoftware.Features.Delivery;

import com.gigneticsoftware.Features.Users.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Entity
@Table(name = "driver_live_location")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverLocation {
    @Id
    private String driverId; // Shared Key with User ID

    @OneToOne
    @MapsId
    @JoinColumn(name = "driver_id")
    private User driver;

    @Column(columnDefinition = "geometry(Point,4326)")
    private Point currentLocation; // Real-time GPS ping

    private LocalDateTime lastUpdated;
}
