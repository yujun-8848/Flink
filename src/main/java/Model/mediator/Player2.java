package Model.mediator;

public class Player2 {

    public int money = 100;
    public Group group;

    public Player2(Group group) {
        this.group = group;
    }

    public void change(int money){
        group.money += money;
        this.money += money;
    }
}
