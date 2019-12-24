package xialu.drools.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xialu.drools.dao.PromoteExecuteDao;
import xialu.drools.model.PromoteExecute;
import xialu.drools.model.RuleResult;
import xialu.drools.util.UUIDUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PromoteEdieServcie {

    @Autowired
    private PromoteExecuteDao promoteExecuteDao;
    @Autowired
    private PromoteNeaten promoteNeaten;

    private Map<String, PromoteExecute> promoteExecuteMap;

    @Transactional(rollbackFor = Exception.class)
    public void ediePromomteMap(String money, String ruleName) {
        if (this.promoteExecuteMap == null) {
            promoteExecuteMap = new HashMap<>();
        }
        PromoteExecute promoteExecute = new PromoteExecute();
        double v = Double.parseDouble(money);
        String rule = UUIDUtil.rule(ruleWorkMap(ruleName, v));
        String promoteCode = UUIDUtil.typeJoinTime();
        promoteExecute.setPromoteCode(promoteCode);
        promoteExecute.setWorkContent(rule);
        promoteExecute.setPromoteName(ruleName);
        int i = promoteExecuteDao.insertPromoteExecute(promoteExecute);
        if (i > 0) {
            PromoteExecute execute = promoteNeaten.editRule(rule);
            this.promoteExecuteMap.put(promoteCode, execute);
        }
    }

    /**
     * 购物车计算.
     *
     * @param moneySum
     * @return
     */
    public Map<String, Object> toShopping(String moneySum) {
        // 购物车请求信息.
        Map<String, Object> map = new HashMap<>();
        double v = Double.parseDouble(moneySum);
        List<Object> pn = new ArrayList<>();
        if (this.promoteExecuteMap != null) {
            // 证明有优惠卷.
            for (Map.Entry<String, PromoteExecute> codes : this.promoteExecuteMap.entrySet()) {
                RuleResult ruleResult = DrlExecute.rulePromote(codes.getValue(), v);
                v = ruleResult.getFinallyMoney();
                pn.add(ruleResult);
            }
        }
        map.put("moneySumYuanJia", moneySum);
        map.put("youhuiquanjiegou", pn);
        return map;
    }

    /**
     * 组合业务规则Json方法.
     *
     * @param name
     * @param money
     * @return
     */
    public String ruleWorkMap(String name, Double money) {
        Map<String, Object> map = new HashMap<>();
        // 组合rule部分.
        Map<String, Object> rule = new HashMap<>();
        rule.put("name", name);
        map.put("rule", rule);
        // 组合 规则when部分.
        Map<String, Object> when = new HashMap<>();
        map.put("condition", when);
        // 组合 规则then部分.
        Map<String, Object> then = new HashMap<>();
        then.put("money", money);
        map.put("action", then);
        // 组合规则when and then部分.
        return JSONObject.toJSONString(map);
    }

}
