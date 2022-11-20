package bridge.repository;

import static bridge.exception.Validator.checkBridgeLength;

import bridge.BridgeRandomNumberGenerator;
import bridge.maker.BridgeMaker;
import java.util.List;

public class BridgeRepository {

    private int size;
    private List<String> bridge;

    public BridgeRepository(int size) {
        checkBridgeLength(size);
        this.size = size;
        setBridge();
    }

    public void setBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = bridgeMaker.makeBridge(size);
    }
}