package tw.org.iii.helloapp;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class    CLottoGen {


    public String GetLottos(){

        ArrayList<Integer> list  = new ArrayList<Integer>();
        for(int i=1;i<50;i++){
            list.add(i);
        }
        int[] nums =new int[6];
        for(int i=0;i<6;i++){

            int index=(int)(Math.random()*list.size());
            nums[i]=list.get(index);
            list.remove(index);
        }
        for(int i=0;i<nums.length;i++){
            for (int j=0;j<nums.length-1;j++){
                if(nums[j]>nums[j+1]){
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
        String s="";
        for (int i:nums) {
            s+=String.valueOf(i)+"  ";
        }
        return s;
    }
}
