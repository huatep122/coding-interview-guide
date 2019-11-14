public class 用栈来求解汉诺塔问题 {
    // 原始汉诺塔问题
    public int process0(int num, String from, String help, String to) {
        if (num == 1) {
            System.out.println("move " + num + " from " + from + " to " + to);
            return 1;
        }
        int p1 = process1(num - 1, from, to, help);
        int p2 = 1;
        System.out.println("move " + num + " from " + from + " to " + to);
        int p3 = process1(num - 1, help, from, to);
        return p1 + p2 + p3;
    }
    // 新问题，不能直接从左移至右，也不能直接从右移至左。只能经过中间
    // 递归方式
    public int process(int num, String left, String mid, String right, String from, String to) {
        if (num == 1) {
            if (from.equals("mid") || to.equals("mid")) {
                System.out.println("move " + num + " from " + from + " to " + to);
                return 1;
            } else {
                System.out.println("move " + num + " from " + from + " to " + mid);
                System.out.println("move " + num + " from " + mid + " to " + to);
                return 2;
            }
        }
        if (from.equals(mid) || to.equals(mid)) {
            // 把n-1移动到对面
            String another = (from.equals(left) || to.equals(left)) ? right : left;
            int p1 = process(num - 1, left, mid, right, from, another);
            int p2 = 1;
            System.out.println("move " + num + " from " + from + " to " + to);
            int p3 = process(num - 1, left, mid, right, another, to);
            return p1 + p2 + p3;
        } else {
            int p1 = process(num - 1, left, mid, right, from, to);
            int p2 = 1;
            System.out.println("move " + num + " from " + from + " to " + mid);
            int p3 = process(num - 1, left, mid, right, to, from);
            int p4 = 1;
            System.out.println("move " + num + " from " + mid + " to " + to);
            int p5 = process(num - 1, left, mid, right, from, to);
            return p1 + p2 + p3 + p4 + p5;
        }
    }

    // 栈实现
    
}