package com.gigneticsoftware.Features.Users;

import jakarta.persistence.*;
import lombok.*;
import org.locationtech.jts.geom.Point;

@Entity
@Table(name = "user_addresses")
//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SavedAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String tag; // e.g., "Home", "Work"
    private String fullAddress; // "Flat 401, Maple Apts..."

    @Column(columnDefinition = "geometry(Point,4326)")
    private Point location; // GPS Coordinates for pin
}
