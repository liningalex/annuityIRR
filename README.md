# COLA Annuity IRR Calculator (Java)

This project calculates the **real internal rate of return (IRR)** for
an annuity with:

-   Deferred payout (e.g., starts at age 70)
-   Annual payout growth (COLA)
-   Inflation adjustment (real return)

It helps evaluate whether an annuity is financially attractive under
different lifespan scenarios.

------------------------------------------------------------------------

## 📌 Features

-   IRR calculation using bisection method
-   Inflation-adjusted (real IRR)
-   Growing payouts (COLA)
-   Flexible parameters:
    -   Start age
    -   Payout start age
    -   Lifespan
    -   Investment amount
    -   Payout amount
    -   Inflation rate
    -   Growth rate

------------------------------------------------------------------------

## 🚀 How to Run

Compile: javac AnnuityIRR.java

Run: java AnnuityIRR

------------------------------------------------------------------------

## 📊 Example Scenario 1

-   Age 60: Invest \$500,000
-   Age 70: Start receiving \$70,000/year
-   Payout grows at 0% annually
-   Inflation = 0%
### Sample Output
-   Live to 80 → Real IRR = 2.95%
-   Live to 85 → Real IRR = 4.86%
-   Live to 90 → Real IRR = 5.85%
-   Live to 95 → Real IRR = 6.41%

## 📊 Example Scenario 2

-   Age 60: Invest \$500,000
-   Age 70: Start receiving \$70,000/year
-   Payout grows at 0% annually
-   Inflation = 0.025%
### Sample Output
-   Live to 80 → Real IRR = 0.44%
-   Live to 85 → Real IRR = 2.30%
-   Live to 90 → Real IRR = 3.27%
-   Live to 95 → Real IRR = 3.82%

------------------------------------------------------------------------

## ⚠️ Key Insights

-   If growth rate ≈ inflation, payouts maintain constant purchasing
    power
-   Longer lifespan → higher IRR
-   Useful for evaluating annuities as longevity insurance

------------------------------------------------------------------------

## 📜 License

MIT License
