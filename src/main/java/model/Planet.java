package model;

import java.util.Objects;

public class Planet {
    private String planetName;
    private String behavior;

    public Planet() {
        this.planetName = "";
        this.behavior="";
    }
    public Planet(String planetName) {
        this.planetName = planetName;
    }
    public Planet(String planetName, String behavior) {
        this(planetName);
        this.behavior = behavior;
    }

    public String getPlanetName() {
        return planetName;
    }
    public String getBehavior() {
        return behavior;
    }
    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }

    public void behavior(){
        System.out.println("My behaviour is : "+this.behavior);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return Objects.equals(planetName, planet.planetName) && Objects.equals(behavior, planet.behavior);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planetName, behavior);
    }
}
