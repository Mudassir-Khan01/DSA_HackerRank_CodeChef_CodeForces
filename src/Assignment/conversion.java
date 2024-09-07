package Assignment;

public class conversion {
    public static String binaryToDottedDecimal(String binaryIP) {
        StringBuilder dottedDecimal = new StringBuilder();
        for (int i = 0; i < binaryIP.length(); i += 8) {
            String octet = binaryIP.substring(i, Math.min(i + 8, binaryIP.length()));

            int decimal = Integer.parseInt(octet, 2);
            dottedDecimal.append(decimal);

            if (i < binaryIP.length() - 8) {
                dottedDecimal.append(".");
            }
        }
        return dottedDecimal.toString();
    }
    public static String dottedDecimalToBinary(String dottedDecimalIP) {
        StringBuilder binary = new StringBuilder();

        String[] octets = dottedDecimalIP.split("\\.");

        for (String octet : octets) {
            String binaryOctet = Integer.toBinaryString(Integer.parseInt(octet));
            while (binaryOctet.length() < 8) {
                binaryOctet = "0" + binaryOctet;
            }
            binary.append(binaryOctet);
        }
        return binary.toString();
    }

    public static void main(String[] args) {
        String binaryIP = "11000000101010000000000100000001";
        String dottedDecimalIP = "192.168.1.1";

        // Convert binary to dotted decimal
        System.out.println("Binary to Dotted Decimal:");
        System.out.println("Binary IP: " + binaryIP);
        System.out.println("Dotted Decimal IP: " + binaryToDottedDecimal(binaryIP));

        // Convert dotted decimal to binary
        System.out.println("\nDotted Decimal to Binary:");
        System.out.println("Dotted Decimal IP: " + dottedDecimalIP);
        System.out.println("Binary IP: " + dottedDecimalToBinary(dottedDecimalIP));
    }
}

