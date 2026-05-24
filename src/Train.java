class Train extends Vehicle{

    Train(){
        super(300, 100, 30000, 110, 0.17, Integer.MAX_VALUE);
    }

    @Override
    void Move() {
        System.out.println("기차로 이동합니다");
    }
}