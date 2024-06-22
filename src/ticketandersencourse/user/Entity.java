package ticketandersencourse.user;

import ticketandersencourse.enums.Role;
import ticketandersencourse.interfaces.Printable;
import ticketandersencourse.interfaces.RolePrint;
import ticketandersencourse.validation.Validator;

import java.util.Objects;

public class User implements Printable, RolePrint {
    private int id;
    public User(int id) {
        this.id = new Validator().getValidatedId(id);
    }
    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = new Validator().getValidatedId(id);
    }

    @Override
    public void print() {
        System.out.println(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                '}';
    }

    @Override
    public Role printRole() {
        return Role.valueOf("default");
    }
}
