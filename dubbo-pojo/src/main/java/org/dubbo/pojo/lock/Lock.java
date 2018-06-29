package org.dubbo.pojo.lock;

public interface Lock {
    boolean lock();
    void unlock();
}
