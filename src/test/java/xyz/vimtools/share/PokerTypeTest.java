package xyz.vimtools.share;

import org.junit.Test;
import xyz.vimtools.share.domain.model.cards.Poker;
import xyz.vimtools.share.domain.model.cards.PokerType;
import xyz.vimtools.share.util.PokerUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 扑克牌类型测试类
 *
 * @author zhangzheng
 * @version 1.0.0
 * @date 2017-5-17
 */
public class PokerTypeTest {

    @Test
    public void typeTest() {
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker("AS"));
        pokers.add(new Poker("KS"));
        pokers.add(new Poker("AC"));

        PokerType pokerType = PokerUtils.pokerType(pokers);
        System.out.println(pokerType.getType());
    }
}
