package ru.bankApp.servlets;

public enum HtmlPage {
    START("<html>" +
            "<head>" +
            "<meta http-equiv= \" Content-Type\" content=\"text/html; charset=utf-8\" />" +
            "</head>" +
            "<body>"),
    END("</body></html>");


    String htmlElement;
    /**
     *
     * @param htmlElement
     */
    HtmlPage(String htmlElement){
        this.setHtmlElement(htmlElement);
    }
    /**
     * @param htmlElement
     */
    public void setHtmlElement(String htmlElement) {
        this.htmlElement = htmlElement;
    }

    public String getHtmlElement() {
        return htmlElement;
    }
}
