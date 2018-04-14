package web;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class TestView {

    public TestView() {
        this.text = "Hello World from Bean";
    }

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
