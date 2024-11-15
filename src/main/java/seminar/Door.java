package seminar;

import java.util.Random;

public class Door {
    private final boolean hasCar;

    public Door(boolean hasCar) {
        this.hasCar = hasCar;
    }

    public boolean hasCar() {
        return hasCar;
    }
}
