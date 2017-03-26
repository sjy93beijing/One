package RxTest;

/**
 * 对象是   被观察者
 * Created by sjy_1993 on 2017/3/1.
 */
public interface Watched {
    //添加观察者
    public void addWatcher(Watcher watcher);
    //取消观察者
    public void removeWatcher(Watcher watcher);
    //通知
    public void notifyWatcher(String string);
}
