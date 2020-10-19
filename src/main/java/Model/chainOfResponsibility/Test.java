package Model.chainOfResponsibility;

public class Test {
    public static void main(String[] args) {
        NewbieProgrammer newbie = new NewbieProgrammer();
        NormalProgrammer normal = new NormalProgrammer();
        GoodProgrammer good = new GoodProgrammer();

        Bug easy = new Bug(20);
        Bug mid = new Bug(50);
        Bug hard = new Bug(100);

        //组成责任链
        newbie.setNext(normal);
        normal.setNext(good);
        //处理bug
        newbie.handle(easy);
        newbie.handle(mid);
        newbie.handle(hard);

    }
}
