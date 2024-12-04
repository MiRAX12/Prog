package Objects.Item;

public abstract class Thing {
    private String name;

    public Thing(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object ob) {
        if (ob == this) {
            return true;
        }

        if (ob == null || ob.getClass() != getClass()) {
            return false;
        }
        Thing thing = (Thing) ob;
        return thing.name.equals(name);
    }

    @Override
    public String toString() {
        return "предмет " + this.getName();
    }

}

