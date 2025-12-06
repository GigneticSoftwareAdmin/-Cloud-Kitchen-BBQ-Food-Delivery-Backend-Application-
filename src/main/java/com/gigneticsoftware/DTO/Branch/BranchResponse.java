package com.gigneticsoftware.DTO.Branch;

import lombok.Data;

@Data
public class BranchResponse {
    private String id;
    private String name;
    private boolean isOpen;
    private boolean isServiceable; // True if user is inside polygon
}
