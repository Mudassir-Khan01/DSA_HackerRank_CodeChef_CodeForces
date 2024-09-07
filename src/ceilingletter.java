public class ceilingletter {
    public static void main(String[]args){
        char []letters={'c','f','j'};
        char target= 'h';
        char ans= ceilings(letters,target);
        System.out.println(ans);
    }
    public static char ceilings(char[]letters, char target){
        int start=0;
        int end=letters.length-1;

        while(start<=end){
            int mid=start+(end-start)/2;

            if(target<letters[mid]){
                end=mid-1;
            }else {
                start=mid+1;

            }
        }
        return letters[start%letters.length];//wrap around letters
    }
}



