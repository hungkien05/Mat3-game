public class Chicken {
    static int count = 0;
    //static = biến tĩnh
    double weight;
    String color;
    int age;

    public Chicken() {
        weight = 1;
        color = "yellow";
    }

    public Chicken(double weight, String color, int age) {
        this.weight = weight;
        this.color = color;
        this.age = age;
    }

    public void eat() {
        System.out.println("Eating..");
    }

    public void run() {
        System.out.println("Runing..");
    }

    public void print() {
        System.out.println(this.color);
        // System.out.println(c1.color);
    }
}

//shortcut key

// ctrl + z / x / c / v
// ctrl + shift + z
// ctrl + / = comment/uncomment
// alt + enter: suggest fix code
// shift (+ fn) + F6: change name everywhere
// ctrl + alt + l: format code
