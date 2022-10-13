public class TaxChoice {

    public int taxEarningsMinusSpendings(int earnings, int spendings) {
        return (earnings - spendings) * 15 / 100;
    }

    public int taxEarnings(int earnings) {
        return earnings * 6 / 100;
    }

    public int taxEarningsMinusInsurancePremiums(int earnings, int premiums) {
        int tax = earnings * 6 / 100;
        if (premiums <= tax / 2) {
            return tax - premiums;
        } else {
            return tax / 2;
        }
    }

    public int taxSelfEmployed(int earnings, String contractor) {
        if (contractor == "Юридическое лицо") {
            return earnings * 6 / 100;
        } else {
            return earnings * 4 / 100;
        }
    }
}