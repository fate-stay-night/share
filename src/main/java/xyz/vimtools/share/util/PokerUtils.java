package xyz.vimtools.share.util;

import org.springframework.util.CollectionUtils;
import xyz.vimtools.share.domain.model.cards.Poker;
import xyz.vimtools.share.domain.model.cards.PokerType;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 扑克牌公有类
 *
 * @author zhangzheng
 * @version 1.0.0
 * @date 2017-5-17
 */
public class PokerUtils {

    /**
     * 扑克牌类型
     *
     * @param pokerList 扑克牌list
     * @return PokerType
     */
    public static PokerType pokerType(List<Poker> pokerList) {
        //豹子
        if (isBaoZi(pokerList)) {

            return PokerType.BAO_ZI;
        //顺金
        } else if (isShunJin(pokerList)) {

            return PokerType.SHUN_JIN;
        //金花
        } else if (isJinHua(pokerList)) {

            return PokerType.JIN_HUA;
        //顺子
        } else if (isShunZi(pokerList)) {

            return PokerType.SHUN_ZI;
        //对子
        } else if (isDuiZi(pokerList)) {

            return PokerType.DUI_ZI;
        //散牌
        } else {

            return PokerType.SAN_PAI;
        }
    }

    /**
     * 判断是否是豹子
     *
     * @param pokerList 扑克牌list
     * @return Boolean
     */
    public static Boolean isBaoZi(List<Poker> pokerList) {
        //排序，升序
        Collections.sort(pokerList);
        if (CollectionUtils.isEmpty(pokerList)) {
            return Boolean.FALSE;
        }

        Poker poker = pokerList.get(0);
        for (Poker p : pokerList) {
            if (!p.getPokerPoint().equals(poker.getPokerPoint())) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    /**
     * 判断是否是顺金
     *
     * @param pokerList 扑克牌list
     * @return Boolean
     */
    public static Boolean isShunJin(List<Poker> pokerList) {
        return isJinHua(pokerList) && isShunZi(pokerList);
    }

    /**
     * 判断是否是金花
     *
     * @param pokerList 扑克牌list
     * @return Boolean
     */
    public static Boolean isJinHua(List<Poker> pokerList) {
        //排序，升序
        Collections.sort(pokerList);
        if (CollectionUtils.isEmpty(pokerList)) {
            return Boolean.FALSE;
        }

        Poker poker = pokerList.get(0);
        for (Poker p : pokerList) {
            if (!p.getPokerColor().equals(poker.getPokerColor())) {
                return Boolean.FALSE;
            }
        }

        return Boolean.TRUE;
    }

    /**
     * 判断是否是顺子
     *
     * @param pokerList 扑克牌list
     * @return Boolean
     */
    public static Boolean isShunZi(List<Poker> pokerList) {
        //排序，升序
        Collections.sort(pokerList);
        if (CollectionUtils.isEmpty(pokerList)) {
            return Boolean.FALSE;
        }

        //顺子A23特殊处理
        List<Integer> list = pokerList
                .stream()
                .map(poker -> poker.getPokerPoint().getIndex())
                .collect(Collectors.toList());
        if (list.contains(2) && list.contains(3) && list.contains(14)) {
            return Boolean.TRUE;
        }

        for (int i = 0; i < pokerList.size() - 1; i++) {
            if (pokerList.get(i + 1).getPokerPoint().getIndex() - pokerList.get(i).getPokerPoint().getIndex() != 1) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    /**
     * 判断是否是对子
     *
     * @param pokerList 扑克牌list
     * @return Boolean
     */
    public static Boolean isDuiZi(List<Poker> pokerList) {
        //排序，升序
        Collections.sort(pokerList);
        if (CollectionUtils.isEmpty(pokerList)) {
            return Boolean.FALSE;
        }

        for (int i = 0; i < pokerList.size() - 1; i++) {
            if (pokerList.get(i + 1).getPokerPoint().equals(pokerList.get(i).getPokerPoint())) {
                return Boolean.TRUE;
            }
            continue;
        }
        return Boolean.FALSE;
    }
}
