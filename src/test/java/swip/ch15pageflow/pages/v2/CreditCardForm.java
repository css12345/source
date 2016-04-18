package swip.ch15pageflow.pages.v2;

import swip.ch15pageflow.domain.CreditCard;
import swip.framework.Browser;

import static swip.locators.Id.*;

public class CreditCardForm {

    private Browser browser;

    public CreditCardForm(Browser browser) {
        this.browser = browser;
    }

    public void setCreditCard(CreditCard card) {
        browser.setInputText(CARD_CVV, card.cardCvv);
        browser.setInputText(CARD_NUMBER, card.cardNumber);
        browser.select(CARD_TYPE, card.cardType);
        browser.select(CARD_EXP_MONTH, card.expirationMonth);
        browser.select(CARD_EXP_YEAR, card.expirationYear);
    }
}

