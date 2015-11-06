package org.siani.itrules.cases;

public class Roster {

    private final Person[] players;
    private Person coach;

    public Roster(Person coach, Person... players) {
        this.coach = coach;
        this.players = players;
    }

    public static Person[] players(Person... players) {
        return players;
    }


}
