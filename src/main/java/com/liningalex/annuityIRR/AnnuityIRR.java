package com.liningalex.annuityIRR;

public class AnnuityIRR {

    /**
     * Calculate Net Present Value (NPV) of a cash flow series
     * @param rate discount rate
     * @param cashflows array of cash flows (year 0, 1, 2, ...)
     * @return NPV
     */
    public static double npv(double rate, double[] cashflows) {
        double npv = 0.0;

        for (int t = 0; t < cashflows.length; t++) {
            npv += cashflows[t] / Math.pow(1 + rate, t);
        }

        return npv;
    }

    /**
     * Solve IRR using binary search (bisection method)
     * Finds rate such that NPV = 0
     */
    public static double irr(double[] cashflows) {
        double low = -0.99;   // lower bound (avoid division by zero)
        double high = 1.0;    // upper bound (100%)
        double mid = 0;

        for (int i = 0; i < 1000; i++) {
            mid = (low + high) / 2;
            double npv = npv(mid, cashflows);

            // If NPV is close enough to zero, we found IRR
            if (Math.abs(npv) < 1e-6) {
                return mid;
            }

            // Adjust search range
            if (npv > 0) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return mid; // return best approximation
    }

    /**
     * Calculate REAL IRR (inflation-adjusted)
     *
     * Scenario:
     * - Initial investment at startAge
     * - No payments until payoutStartAge
     * - Payments grow annually (COLA)
     * - Cash flows are deflated by inflation
     *
     * @param startAge starting age (e.g., 60)
     * @param payoutStartAge age when payouts begin (e.g., 70)
     * @param endAge age at death
     * @param investment initial investment (negative cash flow)
     * @param firstPayout first annual payout
     * @param payoutGrowth annual payout increase rate (e.g., 3%)
     * @param inflation annual inflation rate (e.g., 3%)
     * @return real IRR
     */
    public static double calculateRealIRR(int startAge,
                                          int payoutStartAge,
                                          int endAge,
                                          double investment,
                                          double firstPayout,
                                          double payoutGrowth,
                                          double inflation) {

        int years = endAge - startAge + 1;
        double[] realCashflows = new double[years];

        for (int i = 0; i < years; i++) {
            int age = startAge + i;

            double nominalCF = 0;

            if (i == 0) {
                // Initial investment (cash outflow)
                nominalCF = -investment;

            } else if (age >= payoutStartAge) {
                // Number of years since payout started
                int n = age - payoutStartAge;

                // Growing payout (COLA-adjusted)
                nominalCF = firstPayout * Math.pow(1 + payoutGrowth, n);
            }

            // Convert nominal cash flow to real (today's dollars)
            realCashflows[i] = nominalCF / Math.pow(1 + inflation, i);
        }

        return irr(realCashflows);
    }

    public static void main(String[] args) {

        int startAge = 60;
        int payoutStartAge = 70;

        double investment = 500000;
        double firstPayout = 70000;

        double payoutGrowth = 0.0; // 3% annual increase (COLA)
        double inflation = 0.0;    // 3% inflation

        int[] testAges = {80, 85, 90, 95};

        for (int endAge : testAges) {
            double realRate = calculateRealIRR(
                    startAge,
                    payoutStartAge,
                    endAge,
                    investment,
                    firstPayout,
                    payoutGrowth,
                    inflation
            );

            System.out.printf("Live to %d → Real IRR = %.2f%%\n",
                    endAge, realRate * 100);
        }
    }
}