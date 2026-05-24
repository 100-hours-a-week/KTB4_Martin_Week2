abstract class Vehicle{

    final int max_passenger, price, fuel_price, speed, fuel_Tank;
    double fuel_eco;
    volatile int fuel_remain;

    Vehicle(int speed, int max_passenger, int price, int fuel_price, double fuel_eco, int fuel_Tank){
        this.max_passenger = max_passenger;
        this.price = price;
        this.fuel_eco = fuel_eco;
        this.fuel_price = fuel_price;
        this.speed = speed;
        this.fuel_Tank = fuel_Tank;
        this.fuel_remain = fuel_Tank;
    }

    abstract void Move();

    void calculation(int distance){
        System.out.println("최종 걸리는 시간은 " + (double)(distance/speed) + "시간 입니다."); //시간 계산
        System.out.println("최종 비용은 " + (int)(distance/fuel_eco) + "원 입니다"); //가격 계산
    }

    void ValidateVehicle(int passenger){
        System.out.println("총" + (int) Math.ceil((double)passenger/max_passenger) + "대로 운행하겟습니다");
    }
}