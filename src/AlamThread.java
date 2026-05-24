class AlamThread implements Runnable{
    Vehicle vehicle;
    MoveThread moveThread;

    AlamThread(Vehicle vehicle, MoveThread moveThread){
        this.vehicle = vehicle;
        this.moveThread = moveThread;
    }

    @Override
    public void run() {
        while(true){
            if(vehicle.fuel_remain<=0){
                System.out.println("연료가 없어 운행을 중단합니다.");
                moveThread.stop = true;
                break;
            }
        }
    }
}
