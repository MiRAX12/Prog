package Objects.Item;

import java.util.Objects;

public class Pan extends Thing {
    public Pan(String name, int porridgeVolume) {
        super(name);
        this.porridgeVolume = porridgeVolume;
    }

    private int porridgeVolume;

    public int getVolume() {
        return porridgeVolume;
    }

    public void getPorridge(int volume) {
        if (volume <= porridgeVolume)
            this.porridgeVolume -= volume;
        else
            this.porridgeVolume = 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getVolume());
    }

    @Override
    public boolean equals(Object ob) {
        if (ob == this) {
            return true;
        }

        if (ob == null || ob.getClass() != getClass()) {
            return false;
        }
        Pan pan = (Pan) ob;
        return pan.getName().equals(getName()) && pan.getVolume() == getVolume();
    }
}
