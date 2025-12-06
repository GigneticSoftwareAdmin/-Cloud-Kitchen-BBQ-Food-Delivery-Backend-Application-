package com.gigneticsoftware.Features.Support;

import com.gigneticsoftware.Common.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupportTicketRepository extends JpaRepository<SupportTicket, String> {
    List<SupportTicket> findByCustomerId(String customerId);
    List<SupportTicket> findByStatus(TicketStatus status);
}
