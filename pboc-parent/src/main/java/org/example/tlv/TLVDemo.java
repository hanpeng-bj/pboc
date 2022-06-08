package org.example.tlv;


import com.payneteasy.tlv.BerTlv;
import com.payneteasy.tlv.BerTlvParser;
import com.payneteasy.tlv.BerTlvs;
import com.payneteasy.tlv.HexUtil;

import java.util.List;


public class TLVDemo {
    public static void main(String[] args){
        String hexString = "7081B39381B0534833A6AE4F5C68961A7895CE1257B14D9607824F380B9B54465C7F204085CD2ED671FAD1E8B89507DC1A292BCF6EF6A809D92F3E280B4DA24FD96A5E4D8B4C0203142EFA97FF50BF65A4A92F143C6A8389FE6AA1A9A173641ECD0D6B677E79692C4D1B2C804BF9D113BEC64402F8C3734876423765807FD0E91A28CF65BFDE81A49323F3A7C3D277824513A39D7C51A7029CE432D1FA2F91574C0F191C081B8C4C9CA2E364D50CFF737A5DA03BF513";//HexUtil.toHexString(bytes);
        byte[] bytes2 = HexUtil.parseHex(hexString);
        BerTlvParser parser = new BerTlvParser();
        BerTlvs tlvs = parser.parse(bytes2, 0, bytes2.length);
        List<BerTlv> list = tlvs.getList();
        parseTLV(list);
    }

    private static void parseTLV(List<BerTlv> list) {
//        System.out.println(list);
        for (BerTlv berTlv : list) {
            if (berTlv.isConstructed()) {
                System.out.println(berTlv.getTag());
//                System.out.println(berTlv.getTag().bytes[0]);
                parseTLV(berTlv.getValues());
            } else {

                System.out.println(berTlv.getTag() + " " + berTlv.getHexValue());
            }
        }
    }
}




