package Model.chainOfResponsibility;

public class NewbieProgrammer extends Programmer {
    @Override
    void handle(Bug bug) {
        if(bug.value >0 && bug.value <= 20){
            slove(bug);
        }else if(next != null){
            next.handle(bug);
        }
    }

    private void slove(Bug bug){
        System.out.println("菜鸟程序员解决了一个难度为"+bug.value + "的bug");
    }
}
