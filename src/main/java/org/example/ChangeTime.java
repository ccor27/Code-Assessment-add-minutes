package org.example;

public class ChangeTime {

    public  String addTime(String time, int minutesToAdd){
        String timePattern =  "^(1[0-2]|0?[1-9]):[0-5][0-9] [APap][mM]$";
        if(!time.matches(timePattern)){//validate that the format of the time is correct
            throw new RuntimeException("Format in the time incorrect");
        }
        String[] array = time.split(" ");//array where is the time(HH:MM) and the time type (AM/PM)
        String timeWithoutType = array[0];// extract only the time(HH:MM)
        String timeType = array[1];//extract the time type (AM/PM)
        String[] hoursAndMinutes = timeWithoutType.split(":");//array where is the hour and the minutes
        int hour = Integer.parseInt(hoursAndMinutes[0]);// extract the hour
        int minutes = Integer.parseInt(hoursAndMinutes[1]); // extract the minutes

        //extract the hour after that, convert it to minutes, add the minutes of the time
        // and finally add the minutes sent as parameter
        int hoursInMinutes = (hour*60)+minutes+minutesToAdd;
        int finalHours = hoursInMinutes/60;//find the final hour
        int finalMinutes = hoursInMinutes%60;//find the final minutes

        //process to know what type of time is
        String finalTimeType=timeType;
        switch (hour) {
            case 1 -> {
                if (finalHours - hour == 11)
                    finalTimeType = timeType.equalsIgnoreCase("AM") ? "PM" : "AM";
            }
            case 2 -> {
                if (finalHours - hour == 10)
                    finalTimeType = timeType.equalsIgnoreCase("AM") ? "PM" : "AM";
            }
            case 3 -> {
                if (finalHours - hour == 9)
                    finalTimeType = timeType.equalsIgnoreCase("AM") ? "PM" : "AM";
            }
            case 4 -> {
                if (finalHours - hour == 8)
                    finalTimeType = timeType.equalsIgnoreCase("AM") ? "PM" : "AM";
            }
            case 5 -> {
                if (finalHours - hour == 7)
                    finalTimeType = timeType.equalsIgnoreCase("AM") ? "PM" : "AM";
            }
            case 6 -> {
                if (finalHours - hour == 6)
                    finalTimeType = timeType.equalsIgnoreCase("AM") ? "PM" : "AM";
            }
            case 7 -> {
                if (finalHours - hour == 5)
                    finalTimeType = timeType.equalsIgnoreCase("AM") ? "PM" : "AM";
            }
            case 8 -> {
                if (finalHours - hour == 4)
                    finalTimeType = timeType.equalsIgnoreCase("AM") ? "PM" : "AM";
            }
            case 9 -> {
                if (finalHours - hour == 3)
                    finalTimeType = timeType.equalsIgnoreCase("AM") ? "PM" : "AM";
            }
            case 10 -> {
                if (finalHours - hour == 2)
                    finalTimeType = timeType.equalsIgnoreCase("AM") ? "PM" : "AM";
            }
            case 11 -> {
                if (finalHours - hour == 1)
                    finalTimeType = timeType.equalsIgnoreCase("AM") ? "PM" : "AM";
            }
            case 12 -> {
                if (finalHours - hour == 12)
                    finalTimeType = timeType.equalsIgnoreCase("AM") ? "PM" : "AM";

            }
            default -> throw new IllegalStateException("Unexpected value: " + hour);
        }

        return finalHours+":"+finalMinutes+" "+finalTimeType;
    }
}
