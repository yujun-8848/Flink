package Model.chainOfResponsibility;

public class GoodProgrammer  extends Programmer{
    @Override
    void handle(Bug bug) {
        if(bug.value > 50 && bug.value <= 100){
            slove(bug);
        }else if(next != null){
            next.handle(bug);
        }
    }

    private void slove(Bug bug){
        System.out.println("优秀程序员解决了一个难度为"+bug.value + "的bug");
    }
}
