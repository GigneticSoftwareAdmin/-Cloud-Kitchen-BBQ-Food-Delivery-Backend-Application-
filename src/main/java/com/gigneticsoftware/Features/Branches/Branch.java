package com.gigneticsoftware.Features.Branches;

import com.gigneticsoftware.Features.Users.User;
import jakarta.persistence.*;
import lombok.Data;
import org.locationtech.jts.geom.Polygon; // Requires hibernate-spatial

@Entity
@Table(name = "branches")
@Data
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "manager_id")
    private User manager;

    // Geo-fencing Zone (Delivery Area)
    @Column(columnDefinition = "geometry(Polygon,4326)")
    private Polygon serviceArea;

    private boolean isOpen = true; // Master Switch (Offline/Online)
}
