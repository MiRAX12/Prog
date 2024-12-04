package Interfaces;

import Enums.Mood;
import Objects.Entity.Person;

public interface Moodable {
    public void setMood(Mood mood);
    public void setMood(Person person);
    public void mood();
    public Mood getMood();
}
