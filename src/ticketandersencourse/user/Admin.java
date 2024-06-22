package ticketandersencourse.user;

import ticketandersencourse.enums.Role;
import ticketandersencourse.interfaces.Printable;
import ticketandersencourse.interfaces.RolePrint;

public class Admin implements RolePrint, Printable {

    public Admin() {

    }

    public void checkTicket() {
        System.out.println("Ticket is checked ");
    }

    @Override
    public Role printRole() {
        return Role.Admin;
    }
    @Override
    public void print() {
        System.out.println("Overrided implementation of print() method for Admin class");
    }

}
