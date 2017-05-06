package xyz.vimtools.share.domain.model.cards;

/**
 * 扑克牌
 *
 * @author zhangzheng
 * @version 1.0.0
 * @date 2017-5-6
 */
public class Poker implements Comparable<Poker> {

    /**
     * 扑克牌的点数
     */
    private PokerPoint pokerPoint;

    /**
     * 扑克牌的花色
     */
    private PokerColor pokerColor;

    Poker(String s) {
        this.pokerPoint = PokerPoint.valueOf(s.substring(0, 1));
        this.pokerColor = PokerColor.valueOf(s.substring(1, 2));
    }

    public PokerPoint getPokerPoint() {
        return pokerPoint;
    }

    public void setPokerPoint(PokerPoint pokerPoint) {
        this.pokerPoint = pokerPoint;
    }

    public PokerColor getPokerColor() {
        return pokerColor;
    }

    public void setPokerColor(PokerColor pokerColor) {
        this.pokerColor = pokerColor;
    }

    /**
     * 重载比较方法
     */
    @Override
    public int compareTo(Poker o) {
        //比较牌面点数
        int compare = this.getPokerPoint().compareTo(o.getPokerPoint());

        //比较牌面花色
        if (compare == 0) {
            return this.getPokerColor().compareTo(o.getPokerColor());
        }
        return compare;
    }
}
