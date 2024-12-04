package Objects.Entity;

import Enums.Eating;
import Enums.Mood;
import Exceptions.IHaveNoPlate;
import Interfaces.CanEat;
import Interfaces.Moodable;
import Objects.Item.Pan;

public class Karlson extends Person implements Moodable {
    public Karlson(String name) {
        super(name);
    }
    private Mood mood;

    @Override
    public void setMood(Person person) {
        if (person instanceof CanEat) {
            if (((CanEat) person).getEating() == Eating.ISEATING)
                this.mood = Mood.NOLAUGH;
            else
                this.mood = Mood.CALM;
        }
    }

    @Override
    public void setMood(Mood mood) { this.mood = mood; }

    @Override
    public Mood getMood(){
        return mood;
    }

    @Override
    public void mood(){
        switch (mood){
            case HAPPY:
                System.out.print(getName() + " был счастлив. ");
                break;
            case CALM:
                System.out.print(getName() + " был спокоен. ");
                break;
            case NOLAUGH:
                System.out.print(getName() + " было не до смеха. ");
                break;
            case GLOOMY:
                System.out.print(" Всё ещё мрачный как туча, ");
        }
    }

    @Override
    public void putInPlate(Pan pan) throws IHaveNoPlate {
        if (getPlate()==null) throw new IHaveNoPlate("а тарелки то нет, как же без нее?");
        System.out.println(" и принялся накладывать кашу в " + this.getPlate().type() + ".");
        pan.getPorridge(this.getPlate().volume());
        if (pan.getVolume()==0)
            System.out.print("Он накладывал и накладывал, а когда выскреб все до дна," +
                    " стал водить указательным пальцем по стенке кастрюли," +
                    " отколупывая и то, что прилипло.");
        else if (pan.getVolume()>0) {
            System.out.print("Он накладывал и накладывал, однако дна не увидел." +
                    " Маловата " + this.getPlate().type() + ", подумал " + this.getName());
        }
    }
}
