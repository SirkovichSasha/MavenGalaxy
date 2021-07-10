package model;

import java.util.HashSet;
import java.util.Iterator;

public class Galaxy {
    private String galaxyName;
    private HashSet<Planet> planets;

    public Galaxy() {
        this.galaxyName = "";
        planets = new HashSet<>();
    }

    public Galaxy(String galaxyName) {
        this.galaxyName = galaxyName;
        planets = new HashSet<>();
    }

    public String getGalaxyName() {
        return galaxyName;
    }

    @Override
    public String toString() {
        return "Galaxy{" +
                "galaxyName='" + galaxyName + '\'' +
                '}';
    }

    public void setGalaxyName(String galaxyName) {
        this.galaxyName = galaxyName;
    }

    protected void behaviour() {
        System.out.println(" I am " + this.toString() + " and my behaivour is extremely good");
        System.out.println("My planets behavior + ");
        for (Planet planet : planets) {
           planet.behavior();
        }
    }

    protected boolean addPlanet(Planet p) {
        return this.planets.add(p);
    }

    protected Planet getPlanet(String planetName) {
        for (Planet planet : planets) {
            if (planet.getPlanetName().equals(planetName)) return planet;
        }
        return null;
    }

    protected Planet getPlanet(Planet p) {
        if (planets.contains(p)) return p;
        return null;
    }

    protected boolean delete(Planet p) {
        return planets.remove(p);
    }

    protected boolean delete(String planetName) {
        Iterator itr = planets.iterator();

        while (itr.hasNext()) {
            Planet p = (Planet) itr.next();
            if (p.getPlanetName().equals(planetName))
                itr.remove();
            return true;
        }
        return false;
    }
}
