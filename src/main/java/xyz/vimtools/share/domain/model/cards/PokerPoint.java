package xyz.vimtools.share.domain.model.cards;

/**
 * 扑克牌点数，去除大小王
 *
 * @author zhangzheng
 * @version 1.0.0
 * @date 2017-5-6
 */
public enum PokerPoint {

    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("T", 10),
    J("J", 11),
    Q("Q", 12),
    K("K", 13),
    A("A", 14),;

    /**
     * 扑克牌点数
     */
    private final String point;

    /**
     * 扑克牌点数对应数字大小
     */
    private final Integer index;

    PokerPoint(String point, Integer index) {
        this.point = point;
        this.index = index;
    }

    public String getPoint() {
        return point;
    }

    public Integer getIndex() {
        return index;
    }

    public static PokerPoint getPokerPoint(String point) {
        for (PokerPoint pokerPoint : PokerPoint.values()) {
            if (pokerPoint.getPoint().equals(point)) {
                return pokerPoint;
            }
        }
        return null;
    }
}
