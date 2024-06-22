package ticketandersencourse.user;

import ticketandersencourse.enums.Role;
import ticketandersencourse.interfaces.Printable;
import ticketandersencourse.interfaces.RolePrint;

public class Client implements RolePrint, Printable {
    public Client() {

    }

    @Override
    public Role printRole() {
        return Role.Client;
    }

    public void getTicket() {
        System.out.println("Ticket is received");
    }
    @Override
    public void print() {
        System.out.println("Overrided implementation of print() method for Client class");
    }


}
