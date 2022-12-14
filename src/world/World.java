package world;

import common.enums.ANSIColor;
import common.input.IncorrectNumberOfParameterException;
import common.input.UnrecognizableArgumentException;
import character.Player;
import world.planets.*;

import java.util.ArrayList;
import java.util.Objects;

import static common.input.ParseArg.parseTransition;
import static world.Location.START_LOCATION;

public class World {
    private ArrayList<Location> planets;
    private Location currentPlanet;

    public World() {
        this.planets = new ArrayList<>();
        createPlanets();
    }

    private void createPlanets() {
        planets.add(new Astronomiya("Astronomiya"));
        planets.add(new Belli("Belli"));
        planets.add(new Dimidium("Dimidium"));
        planets.add(new Earth("Earth"));
        planets.add(new Enoplos("Enoplos"));
        planets.add(new Farmako("Farmako"));
        planets.add(new LastPlanet("????"));
        planets.add(new Najemnik("Najemnik"));
        planets.add(new Zounkla("Zounkla"));
        for (Location p : planets) {
            p.createExits();
        }
    }

    public ArrayList<Location> getPlanets() {
        return planets;
    }

    public Location transition() {
        System.out.println(ANSIColor.ANSI_BLUE + "From here you can reach only a few planets:");
        this.currentPlanet.getExits().forEach((k, v) -> {
            if (v) System.out.print(k + ", ");
        });
        System.out.println("what do you want to do ?" + ANSIColor.ANSI_RESET);
        String name = null;
        try {
            name = parseTransition();
        } catch (UnrecognizableArgumentException | IncorrectNumberOfParameterException e) {
            System.out.println("Please enter the correct number of argument.");
        }
        //vérifier si le nom appartient au tableau et vérifier si il peut y aller
        if (!this.currentPlanet.getExits().containsKey(name)) {
            System.out.println("Impossible to go on this planet");
            return null;
        }
        if (!this.currentPlanet.getExits().get(name)) {
            System.out.println("Impossible to go on this planet");
            return null;
        }
        Location planete = null;
        for (Location p : this.planets) {
            if (Objects.equals(p.getName(), name)) planete = p;
        }
        return planete;
    }

    public void start(Player p) {
        this.currentPlanet = this.planets.stream().filter(l -> l.getName().equals(START_LOCATION)).findFirst().get();
        this.currentPlanet.tellStory(p, "");
        do {
            Location planete = transition();
            if(planete == null) continue;
            planete.tellStory(p, this.currentPlanet.getName());
            this.currentPlanet = planete;
        } while (true);

    }
}
