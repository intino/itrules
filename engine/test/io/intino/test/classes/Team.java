package io.intino.test.classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Team {
    private final String name;

    public Team(String name) {
        this.name = name;
    }

    public static class Person {
        private final String name;
        private final LocalDate birthday;
        private final String country;
        private final Gender gender;
        private final List<Team> teams = new ArrayList<>();
        private final List<Pet> pets = new ArrayList<>();

        public Person(String name, LocalDate birthday, String country, Gender gender) {
            this.name = name;
            this.birthday = birthday;
            this.country = country;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public LocalDate getBirthday() {
            return birthday;
        }

        public String getCountry() {
            return country;
        }

        public Gender getGender() {
            return gender;
        }

        public List<Pet> getPets() {
            return pets;
        }

        public void add(Pet pet) {
            pets.add(pet);
        }

        public void add(Team team) {
            teams.add(team);
        }

        public static Person create() {
            return new Person("Pau Gasol", LocalDate.of(1980, 7, 6), "Spain", Gender.Male);
        }

        public static Person createSimple() {
            return new Person("Pau Gasol", null, "", Gender.Male);
        }


        public Person withPets() {
            add(new Pet(Animal.Dog, "Toby"));
            add(new Pet(Animal.Cat, "Chip"));
            add(new Pet(Animal.Pig, "Chop"));
            return this;
        }

        public Person withTeams() {
            add(new Team("Barcelona"));
            add(new Team("Lakers"));
            add(new Team("Bulls"));
            return this;
        }

        public static class Pet {
            private final Animal animal;
            private final String name;

            public Pet(Animal animal, String name) {
                this.animal = animal;
                this.name = name;
            }
        }

        public enum Gender {
            Male, Female
        }

        public enum Animal {
            Dog, Cat, Pig

        }
    }
}
