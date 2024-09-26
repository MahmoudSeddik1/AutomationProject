package subscriptionPage;

import base.BaseTests;
import enums.Enums;
import org.testng.annotations.Test;
import enums.Enums.*;

public class SubscriptionPageTests extends BaseTests {

    private final String expectedLite = "LITE";
    private final String expectedClassic = "CLASSIC";
    private final String expectedPremium = "PREMIUM";
    private final String expectedKwCurrency = "KWD";
    private final String expectedSaCurrency = "SAR";
    private final String expectedBhCurrency = "BHD";
    private final String expectedFrequency = "/month";

    @Test
    public void KSA_LITE(){
        //Expected values to assert against
        String expectedLiteAmount = "15";

        //Extracting the actual name of the subscription from the page
        String name = subscriptionPage.changeCountryTo(Country.KSA)
                 .getSubscriptionName(Subscription.Lite);
        //Asserting against the expected value
        softly.assertEquals(name,expectedLite,
                "Error in Lite Subscription name!");
        //Extracting the actual subscription price from the page
        String price = subscriptionPage.getSubscriptionPrice(Subscription.Lite);

        //Asserting that the actual price contains the expected values that I am looking for
        softly.assertTrue(price.contains(expectedLiteAmount),
                "Expected amount '" + expectedLiteAmount + "' but found '" + price + "'");
        softly.assertTrue(price.contains(expectedSaCurrency),
                "Expected currency '" + expectedSaCurrency + "' but found '" + price + "'");
        softly.assertTrue(price.contains(expectedFrequency),
                "Expected frequency '" + expectedFrequency + "' but found '" + price + "'");

        //Explicitly asserting that the currency
        softly.assertEquals(subscriptionPage.getCurrency(price),expectedSaCurrency,
                "Error in Subscription Currency!");

        softly.assertAll();
    }

    @Test
    public void KSA_CLASSIC(){
        //Expected values to assert against
        String expectedClassicAmount = "25";

        //Extracting the actual name of the subscription from the page
        String name = subscriptionPage.changeCountryTo(Country.KSA)
                .getSubscriptionName(Subscription.Classic);
        //Asserting against the expected value
        softly.assertEquals(name,expectedClassic,
                "Error in Lite Subscription name!");
        //Extracting the actual subscription price from the page
        String price = subscriptionPage.getSubscriptionPrice(Subscription.Classic);

        //Asserting that the actual price contains the expected values that I am looking for
        softly.assertTrue(price.contains(expectedClassicAmount),
                "Expected amount '" + expectedClassicAmount + "' but found '" + price + "'");
        softly.assertTrue(price.contains(expectedSaCurrency),
                "Expected currency '" + expectedSaCurrency + "' but found '" + price + "'");
        softly.assertTrue(price.contains(expectedFrequency),
                "Expected frequency '" + expectedFrequency + "' but found '" + price + "'");

        //Explicitly asserting that the currency
        softly.assertEquals(subscriptionPage.getCurrency(price),expectedSaCurrency,
                "Error in Subscription Currency!");

        softly.assertAll();
    }

    @Test
    public void KSA_PREMIUM(){
        //Expected values to assert against
        String expectedPremiumAmount = "60";

        //Extracting the actual name of the subscription from the page
        String name = subscriptionPage.changeCountryTo(Country.KSA)
                .getSubscriptionName(Subscription.Premium);
        //Asserting against the expected value
        softly.assertEquals(name,expectedPremium,
                "Error in Lite Subscription name!");
        //Extracting the actual subscription price from the page
        String price = subscriptionPage.getSubscriptionPrice(Subscription.Premium);

        //Asserting that the actual price contains the expected values that I am looking for
        softly.assertTrue(price.contains(expectedPremiumAmount),
                "Expected amount '" + expectedPremiumAmount + "' but found '" + price + "'");
        softly.assertTrue(price.contains(expectedSaCurrency),
                "Expected currency '" + expectedSaCurrency + "' but found '" + price + "'");
        softly.assertTrue(price.contains(expectedFrequency),
                "Expected frequency '" + expectedFrequency + "' but found '" + price + "'");

        //Explicitly asserting that the currency
        softly.assertEquals(subscriptionPage.getCurrency(price),expectedSaCurrency,
                "Error in Subscription Currency!");

        softly.assertAll();
    }


    @Test
    public void Bahrain_LITE(){
        //Expected values to assert against
        String expectedAmount = "2";

        //Extracting the actual name of the subscription from the page
        String name = subscriptionPage.changeCountryTo(Country.Bahrain)
                .getSubscriptionName(Subscription.Lite);
        //Asserting against the expected value
        softly.assertEquals(name,expectedLite,
                "Error in Lite Subscription name!");
        //Extracting the actual subscription price from the page
        String price = subscriptionPage.getSubscriptionPrice(Subscription.Lite);

        //Asserting that the actual price contains the expected values that I am looking for
        softly.assertTrue(price.contains(expectedAmount),
                "Expected amount '" + expectedAmount + "' but found '" + price + "'");
        softly.assertTrue(price.contains(expectedBhCurrency),
                "Expected currency '" + expectedBhCurrency + "' but found '" + price + "'");
        softly.assertTrue(price.contains(expectedFrequency),
                "Expected frequency '" + expectedFrequency + "' but found '" + price + "'");

        //Explicitly asserting that the currency
        softly.assertEquals(subscriptionPage.getCurrency(price),expectedBhCurrency,
                "Error in Subscription Currency!");

        softly.assertAll();
    }

    @Test
    public void Bahrain_CLASSIC(){
        //Expected values to assert against
        String expectedAmount = "3";

        //Extracting the actual name of the subscription from the page
        String name = subscriptionPage.changeCountryTo(Country.Bahrain)
                .getSubscriptionName(Subscription.Classic);
        //Asserting against the expected value
        softly.assertEquals(name,expectedClassic,
                "Error in Lite Subscription name!");
        //Extracting the actual subscription price from the page
        String price = subscriptionPage.getSubscriptionPrice(Subscription.Classic);

        //Asserting that the actual price contains the expected values that I am looking for
        softly.assertTrue(price.contains(expectedAmount),
                "Expected amount '" + expectedAmount + "' but found '" + price + "'");
        softly.assertTrue(price.contains(expectedBhCurrency),
                "Expected currency '" + expectedBhCurrency + "' but found '" + price + "'");
        softly.assertTrue(price.contains(expectedFrequency),
                "Expected frequency '" + expectedFrequency + "' but found '" + price + "'");

        //Explicitly asserting that the currency
        softly.assertEquals(subscriptionPage.getCurrency(price),expectedBhCurrency,
                "Error in Subscription Currency!");

        softly.assertAll();
    }

    @Test
    public void Bahrain_PREMIUM(){
        //Expected values to assert against
        String expectedAmount = "6";

        //Extracting the actual name of the subscription from the page
        String name = subscriptionPage.changeCountryTo(Country.Bahrain)
                .getSubscriptionName(Subscription.Premium);
        //Asserting against the expected value
        softly.assertEquals(name,expectedPremium,
                "Error in Lite Subscription name!");
        //Extracting the actual subscription price from the page
        String price = subscriptionPage.getSubscriptionPrice(Subscription.Premium);

        //Asserting that the actual price contains the expected values that I am looking for
        softly.assertTrue(price.contains(expectedAmount),
                "Expected amount '" + expectedAmount + "' but found '" + price + "'");
        softly.assertTrue(price.contains(expectedBhCurrency),
                "Expected currency '" + expectedBhCurrency + "' but found '" + price + "'");
        softly.assertTrue(price.contains(expectedFrequency),
                "Expected frequency '" + expectedFrequency + "' but found '" + price + "'");

        //Explicitly asserting that the currency
        softly.assertEquals(subscriptionPage.getCurrency(price),expectedBhCurrency,
                "Error in Subscription Currency!");

        softly.assertAll();
    }


    @Test
    public void Kuwait_LITE(){
        //Expected values to assert against
        String expectedAmount = "1.2";


        //Extracting the actual name of the subscription from the page
        String name = subscriptionPage.changeCountryTo(Country.Kuwait)
                .getSubscriptionName(Subscription.Lite);
        //Asserting against the expected value
        softly.assertEquals(name,expectedLite,
                "Error in Lite Subscription name!");
        //Extracting the actual subscription price from the page
        String price = subscriptionPage.getSubscriptionPrice(Subscription.Lite);

        //Asserting that the actual price contains the expected values that I am looking for
        softly.assertTrue(price.contains(expectedAmount),
                "Expected amount '" + expectedAmount + "' but found '" + price + "'");
        softly.assertTrue(price.contains(expectedKwCurrency),
                "Expected currency '" + expectedKwCurrency + "' but found '" + price + "'");
        softly.assertTrue(price.contains(expectedFrequency),
                "Expected frequency '" + expectedFrequency + "' but found '" + price + "'");

        //Explicitly asserting that the currency
        softly.assertEquals(subscriptionPage.getCurrency(price),expectedKwCurrency,
                "Error in Subscription Currency!");

        softly.assertAll();
    }

    @Test
    public void Kuwait_CLASSIC(){
        //Expected values to assert against
        String expectedAmount = "2.5";


        //Extracting the actual name of the subscription from the page
        String name = subscriptionPage.changeCountryTo(Country.Kuwait)
                .getSubscriptionName(Subscription.Classic);
        //Asserting against the expected value
        softly.assertEquals(name,expectedClassic,
                "Error in Lite Subscription name!");
        //Extracting the actual subscription price from the page
        String price = subscriptionPage.getSubscriptionPrice(Subscription.Classic);

        //Asserting that the actual price contains the expected values that I am looking for
        softly.assertTrue(price.contains(expectedAmount),
                "Expected amount '" + expectedAmount + "' but found '" + price + "'");
        softly.assertTrue(price.contains(expectedKwCurrency),
                "Expected currency '" + expectedKwCurrency + "' but found '" + price + "'");
        softly.assertTrue(price.contains(expectedFrequency),
                "Expected frequency '" + expectedFrequency + "' but found '" + price + "'");

        //Explicitly asserting that the currency
        softly.assertEquals(subscriptionPage.getCurrency(price),expectedKwCurrency,
                "Error in Subscription Currency!");

        softly.assertAll();
    }

    @Test
    public void Kuwait_PREMIUM(){
        //Expected values to assert against
        String expectedAmount = "4.8";

        //Extracting the actual name of the subscription from the page
        String name = subscriptionPage.changeCountryTo(Country.Kuwait)
                .getSubscriptionName(Subscription.Premium);
        //Asserting against the expected value
        softly.assertEquals(name,expectedPremium,
                "Error in Lite Subscription name!");
        //Extracting the actual subscription price from the page
        String price = subscriptionPage.getSubscriptionPrice(Subscription.Premium);

        //Asserting that the actual price contains the expected values that I am looking for
        softly.assertTrue(price.contains(expectedAmount),
                "Expected amount '" + expectedAmount + "' but found '" + price + "'");
        softly.assertTrue(price.contains(expectedKwCurrency),
                "Expected currency '" + expectedKwCurrency + "' but found '" + price + "'");
        softly.assertTrue(price.contains(expectedFrequency),
                "Expected frequency '" + expectedFrequency + "' but found '" + price + "'");

        //Explicitly asserting that the currency
        softly.assertEquals(subscriptionPage.getCurrency(price),expectedKwCurrency,
                "Error in Subscription Currency!");

        softly.assertAll();
    }
}
