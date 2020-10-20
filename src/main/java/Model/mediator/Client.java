package Model.mediator;

import org.junit.Test;

public class Client {
    @Test
    public void test() {
        Player player = new Player();
        Player player1 = new Player();
        player.win(player1, 20);
        System.out.println(player.money);
        System.out.println(player1.money);
    }

    @Test
    public void test2() {
        Group group = new Group();
        Player2 player2 = new Player2(group);
        Player2 player21 = new Player2(group);
        player2.change(10);
        player21.change(-21);
        System.out.println(player2.money);
        System.out.println(player21.money);
        System.out.println(group.money);

    }
}
