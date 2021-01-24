package com.uki.ssi;

public class Stock {
    private String year ="0000";
    private float growth=0, stability=0, interest=0;

    /* part1. growth*/
    private long take=0;//매출액
    private long tangibleAssets=0;//유형자산
    /* part2. stability*/
    private float debtRatio=0;//부채비율(부채/자본)
    private float currentRatio=0;//당기순이익/매출액
    /* part3. interest*/
    private float roe=0;//당기순이익/자기자본
    private float netMarginOfSales=0;//매출액순이익률 (당기순이익/매출액)
    /* part4. basic*/
    private long cucrrentAssets=0;//유동자산
    private long floatingDebt=0;//유동부채
    private long totalLiabilities=0;//부채총계
    private long totalEquity=0;//자본총계
    private long netIncome=0;//당기순이익
    private long capital=0;//자본금(자기자본)
    private long earningPershare=0;//주당순이익

    Stock(){;}
    //method
    private void calDebtRatio() {
        if(totalEquity != 0) {
            debtRatio = totalLiabilities/totalEquity;
        }
    }
    private void calCurrentRatio() {
        if(take != 0) {
            currentRatio = totalLiabilities/take;
        }
    }
    private void calROE() {
        if(capital != 0) {
            roe = netIncome/capital;
        }
    }
    private void calNetMarginOfSales() {
        if(capital != 0) {
            netMarginOfSales = netIncome/take;
        }
    }
    //set
    public void setTake(long _take){this.take=_take;}
    public void setTangibleAssets(long _tangibleAssets){this.tangibleAssets=_tangibleAssets;}
    public void setDebtRatio(float _debtRatio){this.debtRatio=_debtRatio;}
    public void setCurrentRatio(float _currentRatio){this.currentRatio=_currentRatio;}
    public void setROE(float _roe){this.roe=_roe;}
    public void setNetMarginOfSales(float _netMarginOfSales){this.netMarginOfSales=_netMarginOfSales;}
    public void setCcrrentAssets(long _cucrrentAssets){this.cucrrentAssets=_cucrrentAssets;}
    public void setFloatingDebt(long _floatingDebt) {this.floatingDebt=_floatingDebt;}
    public void setTotalLiabilities(long _totalLiabilities) {this.totalLiabilities=_totalLiabilities;}
    public void setTotalEquity(long _totalEquity) {this.totalEquity=_totalEquity;}
    public void setNetIncome(long _netIncome) {this.netIncome=_netIncome;}
    public void setCapital(long _capital) {this.capital=_capital;}
    public void setEarningPershare(long _earningPershare) {this.earningPershare=_earningPershare;}

    public void setScore(float[] _score){
        this.growth=_score[0];
        this.stability=_score[1];
        this.interest=_score[2];
    }
    //get
    public float[] getScore() {
        float res[] = new float[3];
        res[0] = this.growth;
        res[1] = this.stability;
        res[2] = this.interest;
        return res;
    }
    public float getGrowth() { return this.growth;}
    public float getStability() { return this.stability;}
    public float getInterest() { return this.interest;}
}
