import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {
//    public static void main(String[] args) {
//        Object blocker = new Object(); // 블로커로 사용할 객체
//
//        System.out.println("Setting blocker for current thread...");
//        LockSupport.setCurrentBlocker(blocker); // 현재 스레드에 블로커 설정
//
//        System.out.println("Thread is parking...");
//        LockSupport.park(); // 현재 스레드를 대기 상태로 만듦
//
//        System.out.println("Thread resumed.");
//    }

    public static void main(String[] args) {
        // 현재 실행 중인 스레드를 저장
        Thread mainThread = Thread.currentThread();
        Object blocker = new Object();

        // 현재 스레드에 블로커 설정
        System.out.println("Setting current blocker...");
        LockSupport.setCurrentBlocker(blocker);

        // Park 호출 전 확인
        System.out.println("Thread will park now...");

        // 새로운 스레드에서 3초 후 메인 스레드를 언파킹
        new Thread(() -> {
            try {
                Thread.sleep(3000); // 3초 대기
                System.out.println("Unparking the main thread...");
                LockSupport.unpark(mainThread); // ✅ 메인 스레드를 언파킹
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // 현재 스레드를 차단(Park)
        LockSupport.park();

        // Park가 해제된 이후 실행되는 코드
        System.out.println("Thread resumed!");
    }



//    public static void main(String[] args) {
//        Object blocker = new Object();
//
//        System.out.println("Main thread setting blocker...");
//        LockSupport.setCurrentBlocker(blocker);
//
//        System.out.println("Checking blocker for main thread: " + LockSupport.getBlocker(Thread.currentThread()));
//
//        new java.util.Timer().schedule(new java.util.TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("Timer triggered! Unparking main thread...");
//                LockSupport.unpark(Thread.currentThread());
//            }
//        }, 3000);
//
//        System.out.println("Main thread parking...");
//        LockSupport.park();
//
//        System.out.println("Main thread resumed.");
//    }

//    public static void main(String[] args) {
//        Thread thread = new Thread(() -> {
//            Object blocker = new Object();
//            System.out.println(Thread.currentThread().getName() + " started.");
//
//            // 현재 스레드를 블로킹하는 객체 설정
//            LockSupport.setCurrentBlocker(blocker);
//
//            System.out.println(Thread.currentThread().getName() + " is parking...");
//            LockSupport.park(); // 스레드 블로킹
//            System.out.println(Thread.currentThread().getName() + " resumed.");
//        });
//
//        thread.start();
//
//        try {
//            Thread.sleep(2000); // 2초 대기 후 언블로킹
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        // 블로킹 객체 확인
//        Object blocker = LockSupport.getBlocker(thread);
//        System.out.println("Blocker object: " + blocker);
//
//        // 스레드 깨우기
//        System.out.println("Unparking thread...");
//        LockSupport.unpark(thread);
//    }




}
