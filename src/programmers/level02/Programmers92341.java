package programmers.level02;


import java.util.*;

public class Programmers92341 {

    int defaultTime;
    int defaultFee;
    int additionalTime;
    int additionalFee;
    int maxTime = 1439;

    public int[] solution(int[] fees, String[] records) {

        setField(fees);

        Map<String, CarInfo> map = new HashMap<>();

        for (String record : records) {
            ParkingInfo parkingInfo = new ParkingInfo(record);

            int time = parkingInfo.getTime();

            if (parkingInfo.inOrOut) { // IN


                if (map.containsKey(parkingInfo.carNumber)) {

                    CarInfo carInfo = map.get(parkingInfo.carNumber);

                    carInfo.inTime = time;

                } else {

                    map.put(parkingInfo.carNumber, new CarInfo(time));

                }

            } else { // OUT

                CarInfo carInfo = map.get(parkingInfo.carNumber);

                carInfo.addTime(time);

                carInfo.inTime = -1;

            }

        }

        for (Map.Entry<String, CarInfo> entry : map.entrySet()) {

            if (entry.getValue().inTime != -1) {
                entry.getValue().addTime(maxTime);
            }

            entry.getValue().price = calculatorMoney(entry.getValue());
        }


        List<Map.Entry<String, CarInfo>> sorted = new ArrayList<>(map.entrySet());

        sorted.sort(Comparator.comparing(Map.Entry::getKey));

        int[] answer = new int[map.size()];

        int index = 0;
        for (Map.Entry<String, CarInfo> entry : sorted) {
            answer[index] = entry.getValue().price;
            index++;
        }

        return answer;
    }

    private void setField(int[] fees) {
        defaultTime = fees[0];
        defaultFee = fees[1];
        additionalTime = fees[2];
        additionalFee = fees[3];
    }



    private int calculatorMoney(CarInfo carInfo) {

        int time = carInfo.allTime();


        if (time <= defaultTime) {
            return defaultFee;
        }

        time -= defaultTime;



        time = (int) Math.ceil((double) time / additionalTime);


        return defaultFee + (time * additionalFee);
    }


}

class CarInfo {

    List<Integer> times = new ArrayList<>();
    Integer inTime;
    int price = 0;

    public CarInfo(int inTime) {
        this.inTime = inTime;
    }


    public void addTime(int outTime) {
        times.add(outTime - inTime);
    }

    public int allTime() {
        return times.stream()
                .mapToInt(Integer::valueOf)
                .sum();
    }

}

class ParkingInfo {

    String time;
    String carNumber;
    boolean inOrOut; // in true, out false;

    public ParkingInfo(String record) {
        String[] parsing = record.split(" ");
        this.time = parsing[0];
        this.carNumber = parsing[1];
        this.inOrOut = parsing[2].equals("IN");
    }

    public int getTime() {
        String[] arr = this.time.split(":");
        int hour = Integer.parseInt(arr[0]) * 60;
        int minute = Integer.parseInt(arr[1]);
        return hour + minute;
    }

}