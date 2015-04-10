package org.siani.itrules.cases;

public class Roster {

    private Person coach;
    private final Person[] players;

    public Roster(Person coach, Person... players) {
        this.coach = coach;
        this.players = players;
    }

    public static Person[] players(Person... players) {
        return players;
    }


}
