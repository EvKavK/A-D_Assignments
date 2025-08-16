public class Animal {
    private String name;
    private String type;

    public Animal(String name, String type) {
        this.name = name;
        this.type = type.toLowerCase();
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}