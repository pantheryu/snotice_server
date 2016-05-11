package com.kevin.model.structure;

import com.google.common.primitives.Ints;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by spirit on 2016/3/25.
 */
public class HeapTest {
    private int list[];


    private int log2(double x){
        double ret = Math.log(x)/Math.log(2.0d);
        return (int)Math.floor(ret);
    }

    private void swap(int father,int child){
        int tmp = list[father];
        list[father] = list[child];
        list[child] = tmp;
    }

    private void shiftDown(int index){
        int t = index,flag = 0;
        while (index*2 < list.length && flag == 0){
            t=index;
            if (list[index] > list[index*2]){
                t = index * 2;
            }

            if (index*2+1 < list.length){
                if (list[t] > list[index*2+1]){
                    t = index*2+1;
                }
            }

            if (t != index){
                swap(t,index);
                index = t;
            }
            else
                flag = 1;
        }

    }

    private void swap(int i,int j,int[] list){
        int tmp = list[i];
        list[i] = list[j];
        list[j] = tmp;
    }

    private void shiftDown(int index,int[] list,int n){
        Date today = new Date();
        int t = index;
        int flag = 0;
        while (index*2 <= n && flag == 0){
            t=index;
            if (list[index] > list[index*2]){
                t = index * 2;
            }
            if (index*2+1 <= n){
                if (list[t] > list[index*2+1]){
                    t = index*2+1;
                }
            }
            if (t != index ){
                swap(t,index,list);
                index = t;
            }
            else
                flag = 1;
        }
    }


    public int createHeap(int []sqlList){
        this.list = sqlList;
        int size = sqlList.length;
        int headSize = log2(size);
        for (int i = (int)Math.pow(2,headSize); i>0;i--){
            shiftDown(i);
        }

        return 0;

    }

    public void insertHeap(int newMsg){
        list[1] = newMsg;
        shiftDown(1);
    }

    public List<Integer> queryHeap(){
        int []tmp = list.clone();
        int n = list.length-1;
        List<Integer> integers = new ArrayList<Integer>();
//        for (int i=1;i<=list.length-1;i++){
//            integers.add(tmp[1]);
//            tmp[1] = tmp[n-1];
//            n--;
//            shiftDown(1,tmp,n);
//        }

//        for (int i=1;i<tmp.length-2;i++){
//            swap(1,n-1,tmp);
//            n--;
//            shiftDown(1,tmp,n);
//        }

        while (n>1){
            swap(1,n,tmp);
            n--;
            shiftDown(1,tmp,n);
        }
        List<Integer> integerList = Ints.asList(tmp);

        return integerList;
    }
}
