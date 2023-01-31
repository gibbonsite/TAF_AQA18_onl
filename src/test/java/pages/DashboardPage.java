package pages;

import static com.codeborne.selenide.Selenide.open;

public class DashboardPage {
    private final static String pagePath = "index.php?/dashboard";

    public DashboardPage() {

    }

    public DashboardPage(boolean openPageByUrl) {
        if (openPageByUrl) {
            openPageByUrl();
        }
    }

    public void openPageByUrl() {
        open(pagePath);
    }
}
