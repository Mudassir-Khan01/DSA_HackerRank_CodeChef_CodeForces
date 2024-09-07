package Question_queue_Stack;

import java.util.Stack;

public class _3LargestREctangleInHistogram {
    public static void main(String[] args) {
        _3LargestREctangleInHistogram obj=new _3LargestREctangleInHistogram();
    int[]height={2,1,5,6,2,3};
        System.out.println(obj.largestRectangle(height));


    }
    public int largestRectangle(int []height){
        Stack<Integer>stack=new Stack<>();
        int max=0;
        stack.push(0);
        for(int i=0;i<height.length;i++){
            while(!stack.isEmpty()&&height[i]<height[stack.peek()]){//if at particular value its smaller than the value of index present in the stack then I can stop there and get max
              max=getMax(height,stack,max,i);
            }
          stack.push(i);
        }
        int i=height.length;
        while(!stack.isEmpty()){
            max=getMax(height,stack,max,i);
        }
        return max;
    }
    private static int getMax(int[]arr,Stack<Integer>stack,int max,int i){
        int area;
        int popped=stack.pop();
        if(stack.isEmpty()){
            area=arr[popped]*i;//if its the smallest item then we can take it for entire
        }else {
            area=arr[popped]*(i-1-stack.peek());//*right-left
        }
        return Math.max(max,area);
    }

}
