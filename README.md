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

Compile: javac COLAAnnuityIRR.java

Run: java COLAAnnuityIRR

------------------------------------------------------------------------

## 📊 Example Scenario

-   Age 60: Invest \$500,000
-   Age 70: Start receiving \$70,000/year
-   Payout grows at 3% annually
-   Inflation = 3%

------------------------------------------------------------------------

## ⚠️ Key Insights

-   If growth rate ≈ inflation, payouts maintain constant purchasing
    power
-   Longer lifespan → higher IRR
-   Useful for evaluating annuities as longevity insurance

------------------------------------------------------------------------

## 📜 License

MIT License
