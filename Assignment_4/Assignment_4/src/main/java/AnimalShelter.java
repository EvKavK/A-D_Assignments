import java.util.LinkedList;

public class AnimalShelter {
    private LinkedList<Animal> animals = new LinkedList<>();

    public void enqueue(String name, String type) {
        if (!type.equals("dog") && !type.equals("cat")) {
            System.out.println("Only 'dog' or 'cat' are allowed.");
            return;
        }

        animals.addLast(new Animal(name, type));
        System.out.println("Added " + type + ": " + name);
    }

    public void dequeueAny() {
        if (animals.isEmpty()) {
            System.out.println("No animals available.");
            return;
        }

        Animal a = animals.removeFirst();
        System.out.println("Adopted: " + a.getType() + " - " + a.getName());
    }

    public void dequeueType(String type) {
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getType().equals(type)) {
                Animal a = animals.remove(i);
                System.out.println("Adopted " + type + ": " + a.getName());
                return;
            }
        }
        System.out.println("No " + type + "s available.");
    }
}