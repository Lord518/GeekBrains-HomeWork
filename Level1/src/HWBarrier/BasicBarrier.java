package HWBarrier;

import HWBarrier.Barrier;

public class BasicBarrier implements Barrier {
    BasicBarrier() {
    }

    private int lengthDistance;

    public BasicBarrier(int lengthDistance) {
        this.lengthDistance = lengthDistance;
    }

    @Override
    public boolean pass(int s) {
        if (s >= lengthDistance) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "lengthDistance=" + lengthDistance;
    }
}
