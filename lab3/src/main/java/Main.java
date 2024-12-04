import Exceptions.IHaveNoPlate;
import Objects.Entity.*;
import Objects.Item.*;
import Enums.Mood;

public class Main {

    public static void main(String[] args) {
        int plateNumber = 0;
        Malysh malysh = new Malysh("Малыш");
        Karlson karlson = new Karlson("Карлсон");
        Buffet buffet = new Buffet("Буфет");
        Pan pan = new Pan("Кастрюля", 30);

        malysh.setEating(0.5);
        malysh.setCounter(plateNumber);
        karlson.setMood(malysh);

        karlson.mood();
        malysh.takePlate(buffet);
        malysh.say(karlson);

        if (karlson.getMood() == Mood.GLOOMY) {
            malysh.givePlate(karlson);
            karlson.mood();
            karlson.grab(pan);
            try {
                karlson.putInPlate(pan);
            } catch (IHaveNoPlate ex){
                System.out.println(ex.getMessage());
                System.exit(2);
            }
        }
        if (karlson.getMood() == Mood.HAPPY) {
            karlson.mood();
            malysh.grab(pan);
            try {
            malysh.putInPlate(pan);
            } catch (IHaveNoPlate ex){
                System.out.println(ex.getMessage());
                System.exit(2);
            }
        }
    }
}

