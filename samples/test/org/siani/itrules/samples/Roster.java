package org.siani.itrules.samples;

public class Roster {

    private Person coach;
    private final Person[] player;

    public Roster(Person coach, Person[] player) {
        this.coach = coach;
        this.player = player;
    }

    public static Person[] players(Person... players) {
        return players;
    }


}
