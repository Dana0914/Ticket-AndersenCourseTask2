package ticketandersencourse.user;

import ticketandersencourse.enums.Role;
import ticketandersencourse.model.Ticket;

public class Client extends User {
    public Client(int id) {
        super(id);

    }
    public Client() {

    }

    @Override
    public Role printRole() {
        return Role.Client;
    }

    public void getTicket(Ticket ticket) {
        System.out.println("Ticket is received " + ticket);
    }

}
