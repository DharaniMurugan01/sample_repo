public class InfoJenkins {
    public static void main(String[] args) {
        String name = System.getenv("NAME");
        int age = Integer.parseInt(System.getenv("AGE"));
        float weight = Float.parseFloat(System.getenv("WEIGHT"));
        System.out.println("Hello, " + name + "! You are who " + age + " years old and weigh " + weight + " kg.");
    }
}
