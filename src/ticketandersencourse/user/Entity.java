package ticketandersencourse.user;

import ticketandersencourse.validation.Validator;


public abstract class Entity {
    private int id;
    public Entity(int id) {
        this.id = new Validator().getValidatedId(id);
    }
    public Entity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = new Validator().getValidatedId(id);
    }

}
