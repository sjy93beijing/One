package RxTest;

import java.util.ArrayList;
import java.util.List;

/**被观察者实现
 * Created by sjy_1993 on 2017/3/1.
 */
public class ConcreteWatched implements Watched {
    private List<Watcher> mList = new ArrayList<>();


    @Override
    public void addWatcher(Watcher watcher) {
        mList.add(watcher);
    }

    @Override
    public void removeWatcher(Watcher watcher) {
        mList.remove(watcher);
    }
    //通知观察者数组里的   每一个观察者更改消息
    @Override
    public void notifyWatcher(String string) {
        for(Watcher watcher:mList){
            watcher.update(string);

        }
    }
}
