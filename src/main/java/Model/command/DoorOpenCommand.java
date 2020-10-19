package Model.command;

public class DoorOpenCommand  implements ICommand{

    private Door door;

    public void setDoor(Door door) {
        this.door = door;
    }

    @Override
    public void execute() {
        door.openDoor();
    }
}
