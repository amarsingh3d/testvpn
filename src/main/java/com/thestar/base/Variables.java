package com.thestar.base;


public enum Variables {
    //Sign in
    SIGN_IN_BUTTON_TEXT("//p[contains(text(),'Sign In')]"),
    SIGN_IN_EMAIL_INPUT("capture_signIn_signInEmailAddress"),
    SIGN_IN_PASSWORD_INPUT("capture_signIn_currentPassword"),
    SIGN_IN_BUTTON("sign-in-btn"),
    //Topic Page
    TOPIC_MEDIA_CARD_HEADING("//h3[@class='c-mediacard__heading c-feature-mediacard__heading mediacard-headline__long-feature']"),
    TOPIC_MEDIA_CARD_IMAGE("//img[@data-test-id='medicard-image']"),
    //Article page
    YMBII_ARTICLE_BLOCK("//div[@data-lpos='ymbii|1']"),
    //AMP
    CLOSE_SIDE_BAR("//div[@on='tap:sb1.close']"),
    SB_SOCIAL_SECTION("//ul[@class='social-section']"),
    SB_CITY_SECTION("//ul[@class='city-section']"),
    SB_MENU_SECTION("//div[@class='menu-section-label']"),
    SB_VIEW_ALL("//a[contains(text(),'View All')]"),
    AMP_SIDE_BAR("//div[@class='sidebar-handle']"),
    HTML_CLICK_TO_OPEN("//div[@aria-label='Click to open']"),
    EXPENDED_HTML5_COMPONENT("//*[@id='content-box']"),
    //Gift redeem
    GIFT_ACTIVATION_CODE_INPUT("//*[@id='activationCode']"),
    GIFT_ACTIVATION_CODE_HEADER("//span[@class='paragraph']"),
    //Gift purchase
    SELECT_GIFT("//span[@class='MuiTypography-root MuiFormControlLabel-label MuiTypography-body1']"),
    GIFT_HERO("//div[@data-lpos='gifts|hero']"),
    SUBMIT_GIFT("//*[@id='submitGiftSelectForm']"),
    GIFT_KEY_POINT1("//li[@class='key-points-section-item key-point-1']"),
    GIFT_KEY_POINT2("//li[@class='key-points-section-item key-point-2']"),
    GIFT_OFFER_TERMS("//div[@class='gifts-offer-terms section']"),
    GIFT_CONTACT_US("//div[@class='o-contact-us-dropdown-container']"),
    EDIT_GIFT_PACKAGE("//span[@class='edit-gift-button-text']"),
    SUBMIT_GIFT_SELECT_FORM("//span[contains(text(),'Continue')]"),
    GIFT_TERMS("//div[@class='offer-terms']"),
    GIFT_FAQ("//div[@class='faqs-list']"),
    GIFT_MESSAGE("//*[@id='forMessage']"),
    GIFT_FOR_EMAIL("//*[@id='forEmail']"),
    GIFT_FOR_FULL_NAME("//*[@id='forName']"),
    GIFT_FROM_FIRST_NAME("//*[@id='fromFirstName']"),
    GIFT_FROM_LAST_NAME("//*[@id='fromLastName']"),
    GIFT_FROM_EMAIL("//*[@id='fromEmail']"),
    GIFT_PROGRESS_BAR("//div[@class='progress-steps-container']"),
    GIFT_PROGRESS_BAR_STEP_1("//div[contains(text(),'Select')]"),
    GIFT_PROGRESS_BAR_STEP_2("//div[contains(text(),'Personalize')]"),
    GIFT_PROGRESS_BAR_STEP_3("//div[contains(text(),'Purchase')]"),
    GIFT_PROGRESS_BAR_STEP_4("//div[contains(text(),'Send')]"),
    //Search page
    SEARCH_FILTER_PHOTO_VIDEO("type=Image,Slideshow,Video"),
    SEARCH_FILTER_PHOTO("type=Image,Slideshow"),
    SEARCH_FILTER_VIDEO("type=Video"),
    SEARCH_FILTER_AUTHOR("//*[@id='searchformr']/div/div[2]/div[6]/select"),
    SEARCH_FILTER_CONTENT("//*[@id='searchformr']/div/div[2]/div[4]/select"),
    SEARCH_SORT_OLDEST("sortby=publishdate&sortdirection=asc"),
    SEARCH_SORT_NEWEST("sortby=publishdate&sortdirection=desc"),
    SEARCH_SORT_RELEVANCE("sortby=relevance&sortdirection=desc"),
    SEARCH_SORT("//*[@id='searchformr']/div/div[2]/div[2]/select"),
    SEARCH_PRINT_ARCHIVES("//a[contains(text(),'Search print archives')]"),
    REG_SEARCH_FILTERS("//form[@data-lpos='search-results|filters']"),
    REG_SEARCH_PAGINATION("//div[@data-lpos='search-results|pagination']"),
    REG_SEARCH_RESULT("//div[@data-lpos='search-results']"),
    REG_SEARCH_ID("//*[@id='searchformr']"),
    SEARCH_BUTTON("//button[@type='submit']"),
    SEARCH_INPUT("//input[@type='search']"),
    CLOSE_SEARCH("//button[@class='c-button c-button--icon-only c-button--search c-button--search-visible']"),
    OPEN_SEARCH_BUTTON("//button[@class='c-button c-button--icon-only c-button--search']"),
    //Home page
    HOME_CITY_DROPDOWN("//span[@class='c-cityname c-cityname--open']"),
    PAGE_NOT_FOUND("//h1[contains(text(),'Sorry, the page you were looking for is not available')]"),
    HOME_PAGE_USER("//p[contains(text(),'Testing')]"),
    OPEN_MENU_BUTTON("//button[@id='signin']"),
    MANAGE_PROFILE_BUTTON("//*[@id='account-manage-profile']"),
    SUBSCRIPTION_ORDERS("//a[@href='/subscriptions-orders']"),
    BILLING_INFORMATION("//a[contains(text(),'Billing Information')]"),
    NEWSLETTERS_MENU_BUTTON("//*[@id='account-newsletters']"),
    SIGN_OUT_BUTTON("//*[@id='account-sign-out']"),
    NEWSLETTER_ICON_HOME_PAGE("//span[contains(text(),'Newsletters')]"),
    PODCASTS_ICON_HOME_PAGE("//span[contains(text(),'Podcasts')]"),
    PAPER_ICON_HOME_PAGE("//span[contains(text(),'Today’s paper')]"),
    //Express checkout page
    DAPS_LINK_TEXT_EXPRESS_CHECKOUT("//div[@class='redeem-link']"),
    DAPS_LINK_EXPRESS_CHECKOUT( "//a[@href='/redeem-home-delivery']"),
    EXPRESS_CHECKOUT_EMAIL_FIELD_READ_ONLY("//input[@readonly]"),
    EXPRESS_CHECKOUT_EMAIL_INPUT("//input[@name='email']"),
    //Registration wall
    REG_WALL_PARAGRAPH_3("//div[@class='paragraph_3']"),
    REG_WALL_PARAGRAPH_4("//div[@class='paragraph_4']"),
    REG_WALL_PARAGRAPH_1("//div[@class='paragraph_1']"),
    REG_WALL_FORM("//div[@class='basic-paywall-new']"),
    REG_WALL_CTA_BUTTON("//a[@class='paywallButton c-button--meter-wall alcta']"),
    REG_WALL_PARAGRAPH_2("//div[@class='paragraph_2']"),
    //Mobile Inlay
    MOBILE_INLAY_SIGN_IN_LINK("//a[@class='c-header__sign-in-link c-header__sign-in-link--thestar']"),
    MOBILE_INLAY_CLOSE_BUTTON("//a[@class='c-header__close-button c-header__close-button--thestar']"),
    MOBILE_INLAY_P1("//span[@class='c-content__p2 c-content__p2--thestar']"),
    MOBILE_INLAY_P2("//span[@class='c-content__p1 alcta c-content__p1--thestar']"),
    //Newsletter
    NEWSLETTER_TOASTER_MESSAGE("//p[@class='o-indicator__p']"),
    NEWSLETTER_SELECT_ALL("//a[contains(text(),'Select All')]"),
    NEWSLETTER_DESELECT_ALL("//a[contains(text(),'Deselect All')]"),
    NEWSLETTER_CHECK("//input[@class='c-checkbox__input']"),
    NEWSLETTER_FEATURED_TEXT("//div[@class='newsletter-section-title']"),
    NEWSLETTER_FEATURED("//div[@class='newsletter-subscription-recommended-item']"),
    ALL_NEWSLETTER_UNSUBSCRIBED_TOASTER("//p[contains(text(),'All newsletters removed')]"),
    ALL_NEWSLETTER_SUBSCRIBED_TOASTER("//p[contains(text(),' All newsletters added')]"),
    NEWSLETTER_UNSUBSCRIBED_TOASTER("//p[contains(text(),'You've been unsubscribed')]"),
    NEWSLETTER_SUBSCRIBED_TOASTER("//p[contains(text(),'You're signed up!')]"),
    //On-boarding
    SMS_SUCCESS_MESSAGE("//*[@id='phoneNumber-helper-text']"),
    NEXT_BUTTON("//span[contains(text(),'Next')]"),
    BACK_BUTTON("//span[contains(text(),'Back')]"),
    CONTINUE_BUTTON("//span[contains(text(),'Continue')]"),
    CONTINUE_READING("//span[contains(text(),'Continue Reading')]"),
    REG_HERO_ONBOARDING("//div[@data-lpos='onboarding|hero']"),
    REG_HEADER("//div[@data-lpos='header-minimal']"),
    REG_ONBOARDING_APP("//div[@data-lpos='onboarding|app']"),
    REG_CONTACT_US("//div[@data-lpos='contact-us']"),
    REG_ONBOARDING_PAGE("//div[@data-lpos='onboarding|newsletters']"),
    REG_ONBOARDING_HEADING("//h1[@class='primary-heading']"),
    REG_ONBOARDING_HEAD_PARAGRAPH("//h2[@class='head-paragraph']"),
    REG_ONBOARDING_MAIN_PARAGRAPH("//h4[@class='main-paragraph']"),
    MOBILE_INPUT("//*[@id='phoneNumber']"),
    TEXT_ME_APP_BUTTON("//*[@id='submitGetMobileAppPhoneNumber']"),

    //Shop page
    SHOP_PAGE_OTHER_OFFER_COMPONENT("//div[@data-lpos='subscribe|other-options']"),
    SHOP_PAGE_OTHER_OFFER_CARD("//div[@class='shop-package-more-offer-card']"),
    SHOP_PAGE_BENEFIT_COMPONENT("//div[@data-lpos='subscribe|benefits']"),
    SHOP_PAGE_BENEFIT_COMPONENT_IMAGE("//img[@alt='Shop Package Benefits']");
    private String text;

    Variables(String text) {
        this.text = text;
    }

    public String toString() {
        return this.text;
    }
}

