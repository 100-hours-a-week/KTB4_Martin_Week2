class Plane extends Vehicle{

    Plane(){
        super(900,300, 100000, 1200, 0.04, 26000);
    }

    void Move(){
        System.out.println("비행기로 이동합니다");
    }
}