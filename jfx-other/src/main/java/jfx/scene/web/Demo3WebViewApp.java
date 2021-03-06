/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jfx.scene.web;

import java.util.List;
import java.util.function.Consumer;
import javafx.collections.ObservableList;
import javafx.css.CssMetaData;
import javafx.css.Styleable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import jfx.core.app.ContentBox;

/**
 *
 * @author realpai <paiap@outlook.com>
 */
public class Demo3WebViewApp extends ContentBox {

    public static final boolean SHOWING = false;
    public static final String TITLE = "Web - Demo WebView";
    private WebView wv;
    private WebEngine engine;

    @Override
    public void index() {
        baseDemo();
        webEngineDemo();
        webViewDemo();
    }

    public void baseDemo() {
        wv = new WebView();
        getChildren().add(wv);

        wv.prefWidthProperty().bind(this.widthProperty());
        wv.prefHeightProperty().bind(this.heightProperty());

        wv.requestFocus();
        wv.setCursor(Cursor.TEXT);
    }

    /**
     * 通过引擎设置文档为可编辑状态
     */
    public void webEngineDemo() {
        engine = wv.getEngine();
//        engine.loadContent("<html><body style=\"-webkit-user-modify: read-write\"><p>这是一个HTML段落</p></body></html>");
        engine.loadContent("<html><body contenteditable=\"true\"><p>这是一个HTML段落</p></body></html>");
        // engine.executeScript("document.designMode = \"on\" ");
    }

    public void webViewDemo() {
        ObservableList<Node> list = wv.getChildrenUnmodifiable();
        list.forEach(new Consumer<Node>() {
            @Override
            public void accept(Node t) {
                ol(t.toString());
            }
        });
        List<CssMetaData<? extends Styleable, ?>> cssMetaData = wv.getCssMetaData();
        cssMetaData.forEach(new Consumer<CssMetaData<? extends Styleable, ?>>() {
            @Override
            public void accept(CssMetaData<? extends Styleable, ?> t) {
                ol("property - " + t.getProperty());
            }
        });
    }
}
