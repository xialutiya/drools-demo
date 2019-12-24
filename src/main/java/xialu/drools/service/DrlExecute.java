package xialu.drools.service;

import org.kie.internal.command.CommandFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xialu.drools.model.PromoteExecute;
import xialu.drools.model.RuleResult;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class DrlExecute {
    private static DecimalFormat df = new DecimalFormat("######0.00");
    protected static Logger logger = LoggerFactory.getLogger(DrlExecute.class);

    /**
     * 判断购物车中所有参加的活动岗商品.
     *
     * @param promoteExecute
     * @param moneySum
     * @return
     */
    public static RuleResult rulePromote(PromoteExecute promoteExecute, Double moneySum) {

        RuleResult ruleResult = new RuleResult();
        ruleResult.setMoneySum(moneySum);
        logger.info("优惠前价格..." + moneySum);
        List cmdCondition = new ArrayList();
        cmdCondition.add(CommandFactory.newInsert(ruleResult));
        promoteExecute.getWorkSession().execute(CommandFactory.newBatchExecution(cmdCondition));
        logger.info("优惠后价格..." + ruleResult.getFinallyMoney());
        return ruleResult;
    }


}
