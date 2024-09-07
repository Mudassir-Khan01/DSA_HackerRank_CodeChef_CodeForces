package Assignment;
public class ObjectCount {
        private static int count = 0;
        ObjectCount() {
            count++;
        }
        static void showCount() {
            System.out.println("Number of objects created: " + count);
        }
        public static void main(String[] args) {
            ObjectCount obj1 = new ObjectCount();
            ObjectCount obj2 = new ObjectCount();
            ObjectCount obj3 = new ObjectCount();

            ObjectCount.showCount();
        }
    }


