package xyz.vimtools.share.domain.model.cards;

/**
 * 扑克牌花色(从小到大)
 * 方块（Diamond）、梅花（Club）、红桃（Heart）、黑桃（Spade）
 *
 * @author zhangzheng
 * @version 1.0.0
 * @date 2017-5-6
 */
public enum PokerColor {

    DIAMOND("D"),
    CLUB("C"),
    HEART("H"),
    SPADE("S"),
    ;

    /**
     * 扑克牌花色
     */
    private final String color;

    PokerColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public static PokerColor getPokerColor(String color) {
        for (PokerColor pokerColor : PokerColor.values()) {
            if (pokerColor.getColor().equals(color)) {
                return pokerColor;
            }
        }
        return null;
    }
}
