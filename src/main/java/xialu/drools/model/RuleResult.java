package xialu.drools.model;

import java.util.ArrayList;
import java.util.List;

public class RuleResult {
    private double finallyMoney;
    private double moneySum;
    public double getMoneySum;
    private List<String> promoteName = new ArrayList<>();

    public double getFinallyMoney() {
        return finallyMoney;
    }

    public void setFinallyMoney(double finallyMoney) {
        this.finallyMoney = finallyMoney;
    }

    public double getMoneySum() {
        return moneySum;
    }

    public void setMoneySum(double moneySum) {
        this.moneySum = moneySum;
    }

    public double getGetMoneySum() {
        return getMoneySum;
    }

    public void setGetMoneySum(double getMoneySum) {
        this.getMoneySum = getMoneySum;
    }

    public List<String> getPromoteName() {
        return promoteName;
    }

    public void setPromoteName(String promoteName) {
        this.promoteName.add(promoteName);
    }
}
