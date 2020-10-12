package Model.observe;

import java.util.ArrayList;
import java.util.List;

public class XiaoMei {
    private List<Person> list = new ArrayList<>();

    public void addPerson(Person person){
        list.add(person);
    }

    public void notifyPerson(){
        for (Person person : list) {
            person.getMessage("你们过来吧，谁先过来谁就陪我玩游戏！");
        }
    }

    public static void main(String[] args) {
        XiaoMei xiaoMei = new XiaoMei();
        LaoLi laoLi = new LaoLi();
        LaoWang laoWang = new LaoWang();
        xiaoMei.addPerson(laoLi);
        xiaoMei.addPerson(laoWang);
        xiaoMei.notifyPerson();
    }
}
