public class Sightings {
    private String Location;
    private int animalId;

    public Sightings(String location, int animalId) {
        Location = location;
        this.animalId = animalId;
    }

    public String getLocation() {
        return Location;
    }

    public int getAnimalId() {
        return animalId;
    }

    @Override
    public boolean equals(Object otherSightings){
        if (!(otherSightings instanceof Sightings)) {
            return false;
        } else {
            Sightings newSightings = (Sightings) otherSightings;
            return this.getLocation().equals(newSightings.getLocation()) &&
                    this.getAnimalId() == newSightings.getAnimalId();
        }
    }
}
