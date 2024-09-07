package Oops.oops6;

public class main_exception {
    public static void main(String[] args) {
        try {
            String name = "Kunal";
            if (name.equals("Kunal")) {
                throw new myException("name is kunal");
            }
        }
            catch (myException e){
                System.out.println(e.getMessage());
            }catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println("Noraml exception");
        }
        finally {//can create one finally block
            System.out.println("this woill always print");
        }
        }
    }
