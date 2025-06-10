package codingpractice;

public class Test {
    // Instance method
    void num(int a) {
        System.out.println(a);
    }

    // Static method
    static void num1(int a) {
        System.out.println(a);
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.num(10);  // Calls the instance method

        Test.num1(20);  // Calls the static method
    }
}
