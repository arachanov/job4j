package pseudo;

import ru.job4j.pseudo.Shape;

public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("+");
        pic.append("+ +");
        pic.append("+  +");
        pic.append("++++");
        return pic.toString();
    }
}