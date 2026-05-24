import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 자동차 달리는 비용 계산은 같은데
음 일단 인원수 체크를 받고 그 값에 맞춰서 자동차 배정을 해줌.
10인 이하면 자동차 100인 이하면 기차 300인 이하면 비행기

기본값 다들 있고
 각자의 연료량이 정해져있다. 각자의 연비가 잇고
 따라서 거리 값을 받았을때 충전이 필요한 구간이 있음
 충전을 할거임 충전소는 100km단위로 잇다고 가정
 남은 연료에 충분히 넣을 연료 입력
 그거 넣고 가격 측정14143
 인당 얼마로나눔
자동차 마다, 연료 용량, 기본 가격,
* */
class main {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("거리가 얼마나 되나요?");
        int distance = Integer.parseInt(br.readLine()); //거리를 입력 받습니다.
        System.out.println("총 탑승객은 몇명인가요?");
        int passenger = Integer.parseInt(br.readLine());

        Vehicle v;

        System.out.println("어떤 교통을 선택하시겠습니까?\n 1. 열차\n 2. 비행기\n 3. 자동차");

        switch (Integer.parseInt(br.readLine())) {
            case 1:
                v = new Train();
                Travel(v, distance, br, passenger);
                break;

            case 2:
                v = new Plane();
                Travel(v, distance, br, passenger);
                break;
            case 3:
                System.out.println("가솔린 차량으로 이동하시겠습니까? Lpg 차량으로 이동하시겠습니까? 전기 차량으로 이동하시겠습니까 \n1. 가솔린 \n2. LPG\n3. 전기차");
                int ans = Integer.parseInt(br.readLine());
                if(ans == 1){
                    v = new Gasoline();
                    Travel(v, distance, br, passenger);
                    break;
                }
                else if(ans == 2){
                    v = new Lpg();
                    Travel(v, distance, br, passenger);
                    break;
                }
                else if(ans == 3){
                    v = new Electric();
                    Travel(v, distance, br, passenger);
                    break;
                }

        }
    }

    static void Travel(Vehicle v, int distance, BufferedReader br, int passenger){
        v.ValidateVehicle(passenger);
        v.Move();
        MoveThread mt = new MoveThread(v, distance, br);
        AlamThread at = new AlamThread(v, mt);
        Thread t1 = new Thread(mt);
        Thread t2 = new Thread(at);
        t1.start();
        t2.start();
    }
}
