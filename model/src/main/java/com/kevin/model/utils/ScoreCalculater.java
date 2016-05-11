package com.kevin.model.utils;

import com.kevin.model.message.BaseNoticeMessage;

import java.util.Date;

/**
 * Created by spirit on 2016/2/24.
 */
public class ScoreCalculater {
    private static double todayAddition = 0.5;
    private static double outDate = 1000;
    public static double getScore(BaseNoticeMessage baseNoticeMessage,Date today){
        double score = (baseNoticeMessage.getUp()-baseNoticeMessage.getDown() * 0.3);
        double percent = 1 - (getDays(baseNoticeMessage.getDate(),today) / getDays(baseNoticeMessage.getDate(),baseNoticeMessage.getSendDate()));
        score = score * percent;
        return score;
    }

    public static double getDays(Date begin,Date end){
        int day = (end.getYear()-begin.getYear())*365+(end.getMonth() - begin.getMonth()) * 30 + (end.getDay() - begin.getDay());
        if (day == 0)
            return todayAddition;
        else if (day < 0)
            return outDate;
        return day;
    }
}
