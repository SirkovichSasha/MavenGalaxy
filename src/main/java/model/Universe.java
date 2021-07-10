package model;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Universe {
    private String universeName;
    private HashSet<Galaxy> galaxies;

    public Universe() {
        universeName = "";
    }

    public Universe(String universeName) {
        this.universeName = universeName;
    }

    public Universe(String universeName, HashSet<Galaxy> galaxies) {
        this(universeName);
        this.galaxies = galaxies;
    }

    public String getUniverseName() {
        return universeName;
    }

    public void setUniverseName(String universeName) {
        this.universeName = universeName;
    }

    public HashSet<Galaxy> getGalaxies() {
        return galaxies;
    }

    public void setGalaxies(HashSet<Galaxy> galaxies) {
        this.galaxies = galaxies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Universe universe = (Universe) o;
        return Objects.equals(universeName, universe.universeName) && Objects.equals(galaxies, universe.galaxies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(universeName, galaxies);
    }

    public boolean addGalaxy(Galaxy galaxy) {
        return galaxies.add(galaxy);
    }

    public Galaxy getGalaxyByName(String galaxyName) {
        Iterator iterator = galaxies.iterator();
        while (iterator.hasNext()) {
            Galaxy galaxy = (Galaxy) iterator.next();
            if (galaxy.getGalaxyName().equals(galaxyName)) {
                return galaxy;
            }
        }
        return null;
    }

    public Galaxy getGalaxyByObject(Galaxy galaxy) {
        return getGalaxyByName(galaxy.getGalaxyName());
    }

    public Planet getPlanetByName(String planetName) {
        for (Galaxy galaxy : galaxies
        ) {
            Planet planet = galaxy.getPlanet(planetName);
            if (planet != null) return planet;
        }
        return null;
    }

    public Planet getPlanetByObject(Planet planet) {
        return getPlanetByName(planet.getPlanetName());
    }

    public void behaviour() {
        
        int g = new Random().nextInt(10);
        for (int i = 0; i < g; i++) {

            Galaxy galaxy = new Galaxy("G" + i);
            this.addGalaxy(galaxy);

            int p = new Random().nextInt(15);

            for (int j = 0; j < p; j++) {
                Planet planet = new Planet("P" + j);
                galaxy.addPlanet(planet);
            }
        }

    }

}
