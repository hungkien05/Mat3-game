public class FightingCock extends Chicken {
    //weight this.weight ~ super.weight
    //color
    //age
    int damage;

    public FightingCock(int weight, String color, int age, int damage) {
        this.weight = weight;
        this.color = color;
        this.age = age;
        this.damage = damage;
    }

    //eat
    @Override //ky hieu mot ham ghi de cua class cha
    public void eat() {
        super.eat(); // Chicken.eat()
        System.out.println("2x Eating..");
    }
    //run
    //print

}
