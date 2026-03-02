package Session15.Bai03;

import java.util.Stack;

public class MedicationProcessChecker {
    private Stack<String> stack = new Stack<>();
    public boolean checkProcess(String[] actions) {
        reset();
        for (int i = 0; i < actions.length; i++) {
            String action = actions[i];
            if (action.equalsIgnoreCase("PUSH")) {
                stack.push("Medicine");
                System.out.println("PUSH -> Phat thuoc");
            } else if (action.equalsIgnoreCase("POP")) {
                if (stack.isEmpty()) {
                    System.out.println(
                            "Loi tai buoc " + (i + 1) + ": POP khi chua phat thuoc!");
                    return false;
                }
                stack.pop();
                System.out.println("POP -> Hoan tat phat thuoc");
            } else {
                System.out.println("Thao tac khong hop le: " + action);
                return false;
            }
        }

        if (!stack.isEmpty()) {
            System.out.println("Ket thuc ca truc nhung con thuoc chua hoan tat!");
            return false;
        }
        System.out.println("Quy trinh hop le!");
        return true;
    }

    public void reset() {
        stack.clear();
    }
}