package Pattern;

public class arra {
    public static void main(String[] args) {
        float[] marks = {45.7f, 67.8f, 63.4f, 99.2f, 100.0f};
        float num = 67.8f;
        boolean inarray = false;
        for (float element : marks) {
            if (num == element) {
                inarray = true;
                break;
            }

        }
        if (inarray) {
            System.out.println("The value is present");
        } else {
            System.out.println("the value is not present");
        }
    }
}
