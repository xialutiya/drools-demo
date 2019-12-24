package xialu.drools.util;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.codec.digest.DigestUtils;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import java.util.Date;
import java.util.UUID;

import static xialu.drools.util.LossMoneyTemplate.workMoneyST;

public class UUIDUtil {

    private static String UUIDString() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

    public static String UUIDFormatString(String replace) {
        String uuid = UUID.randomUUID().toString().replaceAll(replace, "");
        return uuid;
    }

    public static String MD5AndUUID() {
        String timeJab = String.valueOf(System.currentTimeMillis());
        String concat = UUIDString().concat(timeJab);
        return DigestUtils.md5Hex(concat);
    }

    public static String typeJoinTime() {
        String dateNowStr = StringJointUtil.dateToStringThree(new Date());
        Integer math = (int) ((Math.random() * 9 + 1) * 1000000);
        String code = dateNowStr.concat(math.toString());
        return code;
    }

    public static String rule(String json) {
        String rule = ruleWordExchangsST(json);
        return rule;
    }

   public static String ruleWordExchangsST(String json) {
       STGroup group = new STGroupString(workMoneyST);
       ST stFile = group.getInstanceOf("wordImport");
       ST stRule = group.getInstanceOf("ruleValue");
       JSONObject jsonObject = JSONObject.parseObject(json);
       JSONObject condition = jsonObject.getJSONObject("condition");
       JSONObject action = jsonObject.getJSONObject("action");
       JSONObject rule = jsonObject.getJSONObject("rule");
       stRule.add("condition", condition);
       stRule.add("action", action);
       stRule.add("rule", rule);
       stFile.add("rules", stRule);
       String result = stFile.render();
       return result;
   }
}