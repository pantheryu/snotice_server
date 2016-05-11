package com.kevin.model.structure;

import com.kevin.model.message.BaseNoticeMessage;
import com.kevin.model.utils.ScoreCalculater;
import org.springframework.stereotype.Component;

/*
*
* */
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by spirit on 2016/3/24.
 */
@Component
public class NoticeMessageHeap {
    private BaseNoticeMessage list[];


    private int log2(double x){
        double ret = Math.log(x)/Math.log(2.0d);
        return (int)Math.floor(ret);
    }

    private void swap(int father,int child){
        BaseNoticeMessage tmp = list[father];
        list[father] = list[child];
        list[child] = tmp;
    }

    private void shiftDown(int index){
        Date today = new Date();
        int t = index;
        int flag = 0;
        while (index*2 < list.length && flag == 0){
            t = index;
            if (ScoreCalculater.getScore(list[index],today) > ScoreCalculater.getScore(list[index*2],today)){
                t = index * 2;
            }

            if (index*2+1 < list.length){
                if (ScoreCalculater.getScore(list[t],today) > ScoreCalculater.getScore(list[index*2+1],today)){
                    t = index * 2 + 1;
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

    private void swap(int i,int j,BaseNoticeMessage[] list){
        BaseNoticeMessage tmp = list[i];
        list[i] = list[j];
        list[j] = tmp;
    }

    private void shiftDown(int index,BaseNoticeMessage[] list,int n){
        Date today = new Date();
        int t = index;
        int flag = 0;
        while (index*2 <= n && flag == 0){
            t = index;
            if (ScoreCalculater.getScore(list[index],today) > ScoreCalculater.getScore(list[index*2],today)){
                t = index * 2;
            }
            if (index*2+1 <= n){
                if (ScoreCalculater.getScore(list[t],today) > ScoreCalculater.getScore(list[index*2+1],today)){
                    t = index * 2 + 1;
                }
            }

            if (t != index){
                swap(t,index,list);
                index = t;
            }
            else
                flag = 1;
        }
    }

    public int createHeap(BaseNoticeMessage []sqlList){
        this.list = sqlList;
        int size = sqlList.length;

        int headSize = log2(size);

        for (int i = (int)Math.pow(2,headSize); i>0;i--){
            shiftDown(i);
        }
        return 0;
    }

    public void insertHeap(BaseNoticeMessage newMsg){
        list[1] = newMsg;
        shiftDown(1);
    }



    public List<BaseNoticeMessage> queryHeap(){

        BaseNoticeMessage []tmp = list.clone();
        int n = list.length-1;

        while (n>1){
            swap(1,n,tmp);
            n--;
            shiftDown(1,tmp,n);
        }
        List<BaseNoticeMessage> baseNoticeMessageList = Arrays.asList(tmp);
        if (baseNoticeMessageList.size() > 60)
            return baseNoticeMessageList.subList(1,61);
        return baseNoticeMessageList.subList(1,tmp.length);
    }

}
