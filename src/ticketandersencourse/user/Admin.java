package ticketandersencourse.user;

import ticketandersencourse.enums.Role;
import ticketandersencourse.model.Ticket;

public class Admin extends User {

    public Admin(int id) {
        super(id);
    }
    public Admin() {

    }

    public void checkTicket(Ticket ticket) {
        System.out.println("Ticket is checked " + ticket);
    }

    @Override
    public Role printRole() {
        return Role.Admin;
    }

}
