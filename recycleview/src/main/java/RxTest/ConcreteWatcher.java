package RxTest;

/**
 * 观察者
 * Created by sjy_1993 on 2017/3/1.
 */
public class ConcreteWatcher implements Watcher{
    @Override
    public void update(String string) {
        System.out.print(string);
    }
}
