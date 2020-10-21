package Model.template;

public class MyRequest extends LeaveRequest {
    @Override
    String name() {
        return "小花生";
    }

    @Override
    String reason() {
        return "手断了";
    }

    @Override
    String duration() {
        return "24";
    }
}
