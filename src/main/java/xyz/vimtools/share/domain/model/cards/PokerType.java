package xyz.vimtools.share.domain.model.cards;

/**
 * 炸金花牌的类型
 * 散牌，对子，顺子，金花，顺金，豹子
 *
 * @author zhangzheng
 * @version 1.0.0
 * @date 2017-5-6
 */
public enum PokerType {

    SAN_PAI("sanpai"),
    DUI_ZI("duizi"),
    SHUN_ZI("shunzi"),
    JIN_HUA("jinhua"),
    SHUN_JIN("shunjin"),
    BAO_ZI("baozi"),
    ;

    PokerType(String type) {
        this.type = type;
    }

    /**
     * 炸金花三张牌组合成的类型
     */
    private final String type;

    public String getType() {
        return type;
    }

    public static PokerType getPokerType(String type) {
        for (PokerType pokerType : PokerType.values()) {
            if (pokerType.getType().equals(type)) {
                return pokerType;
            }
        }
        return null;
    }
}
