import java.io.BufferedReader;
import java.io.IOException;

class MoveThread implements Runnable{
    Vehicle vehicle;
    int distance;
    BufferedReader br;
    volatile boolean stop;
    MoveThread(Vehicle vehicle, int distance, BufferedReader br){
        this.vehicle = vehicle;
        this.distance = distance;
        this.br = br;
    }

    int move_distance;

    @Override
    public void run(){
        try{
            while(distance>0 && !stop){
                if(distance>100){
                    move_distance+=100;
                    distance -= 100;
                    vehicle.fuel_remain -= 100/vehicle.fuel_eco;
                    System.out.println(move_distance + "Km만큼 이동하였습니다.\n현재 남은 거리는" +
                                    distance + "Km입니다.\n남은 연료는" + vehicle.fuel_remain + "L/kWh입니다.");
                    System.out.println("주유/충전 후 이동 하시겠습니까? \n 1. 예 \n 2. 아니오");
                    int ans = Integer.parseInt(br.readLine());
                    if(ans == 1){
                        System.out.println("얼만큼 주유/충전 하시겠습니까?");
                        while(true){
                            int charge_fuel = Integer.parseInt(br.readLine());
                            if(vehicle.fuel_remain + charge_fuel > vehicle.fuel_Tank){
                                System.out.println("최대 용량을 초과합니다. 다시 입력해주세요.");
                            } else {
                                vehicle.fuel_remain += charge_fuel;
                                break;
                            }
                        }
                    }
                }
                else{
                    vehicle.fuel_remain -= distance/vehicle.fuel_eco;
                    move_distance += distance;
                    distance = 0;
                    break;
                }
            }
            if(distance == 0){
                System.out.println("목적지에 도착하였습니다. 남은 연료는" + vehicle.fuel_remain + "L/kWh 입니다.");
            }
            else {
                System.out.println("연료가 부족합니다. 이동한 거리 :" + move_distance + "km");
            }
            stop = true;
        } catch (IOException e ){
            System.out.println("입력 오류");
        }

    }
}
