package com.bowensun.film.web;

import org.hibernate.service.spi.ServiceException;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author 郑建雄
 * @program film
 * @description
 * @date 2019/11/6
 */
public class TestClass {

    public static void main(String[] args) {
        List<InvMidReply> invMidReplies = new ArrayList<>();
        invMidReplies.add(new InvMidReply());
        ListIterator<InvMidReply> invMidReplyListIterator = invMidReplies.listIterator();
        List<InvMidReply> combineInvMidReplies = new ArrayList<>();
        while(invMidReplyListIterator.hasNext()){
            InvMidReply invMidReply = invMidReplyListIterator.next();
            //如果是合并后的流水单，根据流水单ID查询合并前的流水单
            List<BwLsdxx> combinelsdxxes = new ArrayList<>();
            BwLsdxx bwLsdxx1 = new BwLsdxx();
            bwLsdxx1.setLsdbh("111");
            BwLsdxx bwLsdxx2 = new BwLsdxx();
            bwLsdxx2.setLsdbh("222");
            combinelsdxxes.add(bwLsdxx1);
            combinelsdxxes.add(bwLsdxx2);
            if(combinelsdxxes.size() < 2){
                continue;
            }
            for(BwLsdxx combineLsdxx : combinelsdxxes){
                try{
                    // 查找出合并前的流水单信息，组装后加入到合并流水单list中
                    InvMidReply combineInvMidReply = (InvMidReply) invMidReply.clone();
                    combineInvMidReply.setAppNo(combineLsdxx.getLsdbh());
//                    combineInvMidReply.setLyxybs(combineLsdxx.getLyxtbs());
//                    combineInvMidReply.setTransId(combineLsdxx.getTransId());
//                    combineInvMidReply.setHbid(invMidReply.getAppNo());
                    combineInvMidReplies.add(combineInvMidReply);
                }catch (CloneNotSupportedException e){
                    throw new ServiceException("SAP流水单开具信息回传失败，克隆原流水单失败");
                }
            }
            // 删除合并的流水单
            invMidReplyListIterator.remove();
        }
        // 将合并前的流水单全部加入到待回传列表中
        invMidReplies.addAll(combineInvMidReplies);
    }



}
