package programs;

public class secondSmallest {
    public static void main(String[] args) {
        int[] intArray = {1,1,9,1,1,6}; //{0,99,66,22,33,44,77,11};  //{99,66,22,33,44,77}; //{1,2,5,6,3,2}; //{44,66,99,77,33,22,55}; 
        int n = intArray.length;

        int first=intArray[0], second=intArray[0];

        boolean flag = false;

        for(int i=1; i<n; i++){
            if(intArray[i] < second || first==second){
                if(intArray[i] < first){
                    second = first;
                    first = intArray[i];
                    flag = true;
                }

                if(!flag){
                    second = intArray[i];
                }
                flag = false;
            }
        }

        System.out.println(first + " " + second);
    }
}