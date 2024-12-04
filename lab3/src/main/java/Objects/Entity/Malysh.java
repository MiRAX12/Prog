package Objects.Entity;

import Enums.Eating;
import Enums.Mood;
import Exceptions.IHaveNoPlate;
import Interfaces.CanEat;
import Interfaces.Talkable;
import Objects.Item.Buffet;
import Interfaces.Moodable;
import Objects.Item.Pan;


public class Malysh extends Person implements Talkable, CanEat {
    public Malysh(String name) {
        super(name);
    }
    private Eating eating;
    private int counter;


    @Override
    public void setEating(double chance) {
        if (Math.random() < chance)
            eating = Eating.ISEATING;
        else
            eating = Eating.NOTEATING;
    }

    @Override
    public Eating getEating() {
        return eating;
    }

    public void takePlate(Buffet buffet) {
        setPlate(buffet.remove(counter));
        System.out.print(this.getName() + " вскочил, вынул из " + buffet.getName()
                + " " + buffet.remove(counter).type());
        buffet.deletePlate(counter);
    }

    @Override
    public void say(Person person) {
        if (getEating() == Eating.ISEATING) {
            System.out.print(" и сказал " + person.getName() + ", чтобы он сам положил себе сколько хочет. ");
            if (person instanceof Moodable) {((Moodable) person).setMood(Mood.GLOOMY);}
        } else {
            System.out.print(" и сказал " + person.getName() + ", что он сам ему всё наложит. ");
            if (person instanceof Moodable) {((Moodable) person).setMood(Mood.HAPPY);}
        }
    }

    @Override
    public void putInPlate(Pan pan) throws IHaveNoPlate{
        if (getPlate()==null) throw new IHaveNoPlate("а тарелки то нет, как же без нее?");
        System.out.println(" и принялся накладывать кашу в " + getPlate().type() + ".");
        pan.getPorridge(getPlate().volume());
        if (pan.getVolume()==0)
            System.out.print("Он накладывал и накладывал, до тех пор, пока не выскреб всё до дна.");
        else if (pan.getVolume()>0) {
            System.out.print("Он накладывал и накладывал, однако дна не увидел." +
                    " Маловата " + getPlate().type() + ", подумал " + getName());
        }
    }
    public void setCounter(int counter) {
        this.counter = counter;
    }
}
