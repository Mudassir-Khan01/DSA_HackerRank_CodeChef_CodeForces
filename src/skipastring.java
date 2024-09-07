public class skipastring {
    public static void main(String[] args) {
        System.out.println(skip("badapplebla"));
        System.out.println(skipapp("badapplbla"));
    }
    static String skip(String up) {
        if (up.isEmpty()) {
            return " ";
        }

        if (up.startsWith("apple")) {
            return skip(up.substring(5));

        } else {
            return up.charAt(0) + skip(up.substring(1));
        }
    }
//skip app when its not apple
        static String skipapp(String up) {
            if (up.isEmpty()) {
                return " ";
            }

            if (up.startsWith("app")&&!up.startsWith("apple")) {
                return skipapp(up.substring(3));

            } else {
                return up.charAt(0) + skipapp(up.substring(1));
            }
    }
}
