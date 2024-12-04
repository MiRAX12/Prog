package Objects.Item;

import java.util.Arrays;

public class Buffet extends Thing {
    public Buffet(String name) {
        super(name);
    }

    private Plate[] buffet = {
            new Plate("Тарелка", 40),
            new Plate("Маленькая супница", 20),
            new Plate("Средняя супница", 30),
    };

    public Plate remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= this.buffet.length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        } else {
            Plate plate = buffet[index];
            return plate;
        }

    }

    public void deletePlate(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= this.buffet.length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        } else {
            buffet[index] = null;
        }
    }
    public void lookInside(){
        System.out.print(Arrays.toString(buffet));
    }

    @Override
    public int hashCode() {
        return super.hashCode() + this.getName().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj.hashCode() == this.hashCode();
    }

    @Override
    public String toString() {
        return this.getName();
    }
}



