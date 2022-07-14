package ch.heg.ig.sda.business;

import java.util.List;
import java.util.ArrayList;

public class House {

    protected List<Character> students; // La liste doit être protected pour être utilisée dans sortingHat() de la classe Hogwarts
    private final HouseName HOUSENAME;
    private final Professor DIRECTOR;
    private final Founder FOUNDER;

    public House(HouseName houseName, Professor director, Founder founder) {
        students = new ArrayList<Character>(250);
        this.HOUSENAME = houseName;
        this.DIRECTOR = director;
        this.FOUNDER = founder;
    }

    public HouseName getHouseName() {
        return HOUSENAME;
    }

    public Professor getDirector() {
        return DIRECTOR;
    }

    public Founder getFounder() {
        return FOUNDER;
    }

}
