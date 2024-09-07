package STack;

public class DynamicImple extends customImple{//
    public DynamicImple() {
        super();//this will call customimple()
    }

    public DynamicImple(int size) {
        super(size);//it will call customImple(size)
    }
    @Override
    public boolean push(int item){
        if(this.isFull()){
            //double teh array size
            int []temp=new int[data.length*2];
            //copy all previous item in new array
            for(int i=0;i<data.length;i++){
                temp[i]=data[i];
            }
            data=temp;
        }
        //at this point we know that array is not fuill
        //insert item
        return super.push(item);
    }

    public static void main(String[] args)throws Exception {
        DynamicImple stack=new DynamicImple(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);//we still can add more though the size is 5
        stack.push(7);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
