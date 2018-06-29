package org.dubbo.pojo.lock;

/**
 * 分布式锁
 */
public class MyLock {
    /**
     * 锁的名称
     */
    private String lockName;
    /**
     * 锁使用次数
     */
    private Long lockCount;
    /**
     * 锁的状态 true可用 false被占用
     */
    private boolean lockStatus;
    /**
     * 是否自动解锁
     */
    private boolean isAutoUnLock;

    public String getLockName() {
        return lockName;
    }

    public void setLockName(String lockName) {
        this.lockName = lockName;
    }

    public Long getLockCount() {
        return lockCount;
    }

    public void setLockCount(Long lockCount) {
        this.lockCount = lockCount;
    }

    public boolean isLockStatus() {
        return lockStatus;
    }

    public void setLockStatus(boolean lockStatus) {
        this.lockStatus = lockStatus;
    }

    public boolean isAutoUnLock() {
        return isAutoUnLock;
    }

    public void setAutoUnLock(boolean autoUnLock) {
        isAutoUnLock = autoUnLock;
    }

    public MyLock(String lockName) {
        this.lockName = lockName;
        this.lockCount = 0l;
        this.lockStatus = true;
        this.isAutoUnLock = false;
    }
}
