package com.gigneticsoftware.DTO.Branch;

import lombok.Data;

import java.util.List;

@Data
public class CreateBranchRequest {
    private String branchName;
    private String managerId; // The ID of the user to assign

    // Location Data (To build the Polygon)
    // We expect a list of points: [[12.97, 77.59], [12.98, 77.60]...]
    private List<List<Double>> polygonCoordinates;

    private String addressText;
}
