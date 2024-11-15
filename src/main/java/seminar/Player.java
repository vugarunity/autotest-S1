package seminar;

class Player {
    private int chosenDoor;

    public void chooseDoor(int doorIndex) {
        this.chosenDoor = doorIndex;
    }

    public int getChosenDoor() {
        return chosenDoor;
    }

    public void switchDoor(int newDoorIndex) {
        this.chosenDoor = newDoorIndex;
    }
}
