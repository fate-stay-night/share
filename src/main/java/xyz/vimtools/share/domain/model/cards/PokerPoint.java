package xyz.vimtools.share.domain.model.cards;

/**
 * 扑克牌点数，去除大小王
 *
 * @author zhangzheng
 * @version 1.0.0
 * @date 2017-5-6
 */
public enum PokerPoint {

    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("T"),
    J("J"),
    Q("Q"),
    K("K"),
    A("A"),;

    private final String point;

    PokerPoint(String point) {
        this.point = point;
    }

    public String getPoint() {
        return point;
    }

    public PokerPoint getPoketPoint(String point) {
        for (PokerPoint pokerPoint : PokerPoint.values()) {
            if (pokerPoint.getPoint().equals(point)) {
                return pokerPoint;
            }
        }
        return null;
    }
}
