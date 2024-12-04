package Objects.Entity;
import Exceptions.IHaveNoPlate;
import Interfaces.CanGrab;
import Interfaces.PutPorridge;
import Objects.Item.Plate;
import Objects.Item.Pan;
import Objects.Item.Thing;

public abstract class Person implements CanGrab, PutPorridge {
    private String name;
    private Plate plate;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPlate(Plate plate) {
        this.plate = plate;
    }

    public Plate getPlate() {return this.plate;}

    public void givePlate(Person person) {
        person.setPlate(this.getPlate());
        this.deletePlate();
    }

    public void deletePlate(){
        this.plate = null;
    }

    @Override
    public void grab(Thing thing) {
        System.out.print(this.getName() + " взял " + thing.getName());
    }

    @Override
    public void putInPlate(Pan pan) throws IHaveNoPlate {
        if (plate==null) throw new IHaveNoPlate("У меня нет тарелки");
        System.out.println(" и принялся накладывать кашу в " + plate.type() + ".");
        pan.getPorridge(plate.volume());
        if (pan.getVolume()==0)
            System.out.print("Он накладывал и накладывал, а когда выскреб все до дна," +
                    " стал водить указательным пальцем по стенке кастрюли," +
                    " отколупывая и то, что прилипло.");
        else if (pan.getVolume()>0) {
            System.out.print(". Он накладывал и накладывал, однако дна не увидел." +
                    " Маловата " + plate.type() + ", подумал" + this.getName());
        }
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
        Person person = (Person) ob;
        return person.name.equals(name);
    }

    @Override
    public String toString() {
        return "персонаж " + this.getName();
    }
}

