package Assignment;
    class OuterClass {
        private int outerValue;

        OuterClass(int value) {
            outerValue = value;
        }
        void outerMethod() {
            System.out.println("Outer method called");
            System.out.println("Outer value: " + outerValue);
        }

        class InnerClass {
            private int innerValue;

            InnerClass(int value) {
                innerValue = value;
            }

            void innerMethod() {
                System.out.println("Inner method called");
                System.out.println("Inner value: " + innerValue);
                outerMethod(); // Calling outer method from inner class
            }
        }
        public static void main(String[] args) {
            OuterClass outerObj = new OuterClass(10);
            OuterClass.InnerClass innerObj = outerObj.new InnerClass(5);

            innerObj.innerMethod();
        }
    }



