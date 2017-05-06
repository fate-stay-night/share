package xyz.vimtools.share.domain.model.cards;

/**
 * 扑克牌花色
 * 黑桃（Spade）、红桃（Heart）、梅花（Club）、方块（Diamond）
 *
 * @author zhangzheng
 * @version 1.0.0
 * @date 2017-5-6
 */
public enum PokerColor {

    SPADE("S"),
    HEART("H"),
    CLUB("C"),
    DIAMOND("D"),
    ;

    private final String color;

    PokerColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public PokerColor getPokerColor(String color) {
        for (PokerColor pokerColor : PokerColor.values()) {
            if (pokerColor.getColor().equals(color)) {
                return pokerColor;
            }
        }
        return null;
    }
}
