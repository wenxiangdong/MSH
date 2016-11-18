package util;

import java.util.Calendar;

import static util.EqualJudgeHelper.judgeEqual;

/**
 * Created by Sorumi on 16/10/12.
 */
public class DateUtil {

    public int year;
    public int month;
    public int day;

    public DateUtil(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public DateUtil() {
        Calendar c = Calendar.getInstance();
        this.year = c.get(Calendar.YEAR);
        this.month = c.get(Calendar.MONTH) + 1;
        this.day = c.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 日期向前递增一天
     */
    public void increase() {
        day = day + 1;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (day > 31) {
                    monthIncrease();
                }
                break;
            //
            case 4:
            case 6:
            case 9:
            case 11:
                if (day > 30) {
                    monthIncrease();
                }
            case 2:
                if (isLeapYear()) {
                    if (day > 29) {
                        monthIncrease();
                    }
                } else {
                    if (day > 28) {
                        monthIncrease();
                    }
                }
                break;
            //
            default:
                break;
        }
    }

    /**
     * 比较两个data
     *
     * @param o
     * @return 比较结果
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof DateUtil) {
            DateUtil dateUtil = (DateUtil) o;
            return compareData(dateUtil);
        }
        return false;
    }

    /**
     * 生成对象的hashcode
     *
     * @return hashcode
     */
    @Override
    public int hashCode() {
        return day;
    }

    /**
     * 分别比较每个数据
     *
     * @param dateUtil
     * @return 比较结果
     */
    private boolean compareData(DateUtil dateUtil) {
        return judgeEqual(year, dateUtil.year) && judgeEqual(month, dateUtil.month) && judgeEqual(day, dateUtil.day);
    }

    /**
     * 判断是否为闰年
     *
     * @return 该年份是否为闰年
     */
    private boolean isLeapYear() {
        if (year % 100 == 0) {
            return year % 400 == 0;
        } else {
            return year % 4 == 0;
        }
    }

    /**
     * increase方法的辅助方法
     */
    private void monthIncrease() {
        day = 1;
        if (month == 12) {
            month = 1;
            year++;
        } else {
            month++;
        }
    }

    @Override
    public String toString() {
        String month = String.valueOf(this.month);
        String day = String.valueOf(this.day);
        if(month.length()==1){
            month="0"+month;
        }
        if(day.length()==1){
            day="0"+day;
        }
        return String.valueOf(year)+"-"+month+"-"+day;
    }
}
