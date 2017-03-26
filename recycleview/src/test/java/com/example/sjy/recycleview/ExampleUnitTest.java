package com.example.sjy.recycleview;

import org.junit.Test;

import RxTest.ConcreteWatched;
import RxTest.ConcreteWatcher;
import RxTest.Watched;
import RxTest.Watcher;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        Watched thief = new ConcreteWatched();

        Watcher p1 = new ConcreteWatcher();
        Watcher p2 = new ConcreteWatcher();
        Watcher p3 = new ConcreteWatcher();
        //订阅
        thief.addWatcher(p1);
        thief.addWatcher(p2);
        thief.addWatcher(p3);

        thief.notifyWatcher("我偷东西了 \n");
     }
}