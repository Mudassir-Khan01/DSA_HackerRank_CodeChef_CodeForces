package Assignment;

public class Construct {
        private int value;

        // Constructor
        Construct(int val) {
            value = val;
            System.out.println("Constructor called with value: " + value);
        }

        void display() {
            System.out.println("Value: " + value);
        }
        public static void main(String[] args) {
            Construct obj1 = new Construct(10); // Constructor called for obj1
            Construct obj2 = new Construct(20); // Constructor called for obj2

            obj1.display();
            obj2.display();
        }
    }

