package xyz.vimtools.share.domain.model;

import xyz.vimtools.share.domain.model.cards.Poker;
import xyz.vimtools.share.domain.model.cards.PokerType;
import xyz.vimtools.share.util.PokerUtils;

import java.util.List;

/**
 * 玩家
 *
 * @author zhangzheng
 * @version 1.0.0
 * @date 2017-5-6
 */
public class Player implements Comparable<Player> {

    /**
     * 用户信息
     */
    private User user;

    /**
     * 所拥有的牌
     */
    private List<Poker> pokerList;

    /**
     * 所拥有的牌类型
     */
    private PokerType pokerType;

    /**
     * 默认构造函数，每个玩家默认有三张牌
     *
     * @param pokerList 扑克牌list
     */
    public Player(List<Poker> pokerList) {
        this.pokerList = pokerList;
        this.pokerType = PokerUtils.pokerType(pokerList);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Poker> getPokerList() {
        return pokerList;
    }

    public void setPokerList(List<Poker> pokerList) {
        this.pokerList = pokerList;
    }

    public PokerType getPokerType() {
        return pokerType;
    }

    public void setPokerType(PokerType pokerType) {
        this.pokerType = pokerType;
    }

    @Override
    public int compareTo(Player o) {
        return 0;
    }
}
