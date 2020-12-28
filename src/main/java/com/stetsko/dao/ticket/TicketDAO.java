package com.stetsko.dao.ticket;

import com.stetsko.dao.DAO;
import com.stetsko.entity.ticket.Ticket;

public interface TicketDAO extends DAO<Ticket> {
    Ticket getByPrice (double price);
    Ticket getByMovieTitle (String movie);
}
